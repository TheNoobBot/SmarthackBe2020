package com.smarthack.sudo.service;

import com.smarthack.sudo.converters.impl.PrescriptionMapper;
import com.smarthack.sudo.domain.Order;
import com.smarthack.sudo.domain.OrderedMedicine;
import com.smarthack.sudo.domain.Pharmacy;
import com.smarthack.sudo.domain.Prescription;
import com.smarthack.sudo.domain.User;
import com.smarthack.sudo.dto.PrescriptionDto;
import com.smarthack.sudo.prescriptions.model.requests.MedicineOrderRequest;
import com.smarthack.sudo.prescriptions.model.requests.MedicineSearchRequest;
import com.smarthack.sudo.prescriptions.model.requests.OrderRequest;
import com.smarthack.sudo.prescriptions.model.requests.SearchMedicineRequest;
import com.smarthack.sudo.prescriptions.model.responses.MedicineResponse;
import com.smarthack.sudo.prescriptions.model.responses.MedicineSearchResponse;
import com.smarthack.sudo.prescriptions.model.responses.SearchMedicineResponse;
import com.smarthack.sudo.repository.OrderRepository;
import com.smarthack.sudo.repository.OrderedMedicineRepository;
import com.smarthack.sudo.repository.PatientRepository;
import com.smarthack.sudo.repository.PharmacyRepository;
import com.smarthack.sudo.repository.PrescriptionRepository;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrescriptionService {

    private final OrderRepository orderRepository;
    private final PrescriptionRepository prescriptionRepository;
    private final PatientRepository patientRepository;
    private final PrescriptionMapper prescriptionMapper;
    private final PharmacyRepository pharmacyRepository;
    private final RestTemplate restTemplate;
    private final OrderedMedicineRepository orderedMedicineRepository;

    public PrescriptionService(OrderRepository orderRepository, PrescriptionRepository prescriptionRepository, PatientRepository patientRepository, PrescriptionMapper prescriptionMapper, PharmacyRepository pharmacyRepository, RestTemplate restTemplate, OrderedMedicineRepository orderedMedicineRepository) {
        this.prescriptionRepository = prescriptionRepository;
        this.patientRepository = patientRepository;
        this.prescriptionMapper = prescriptionMapper;
        this.pharmacyRepository = pharmacyRepository;
        this.restTemplate = restTemplate;
        this.orderRepository = orderRepository;
        this.orderedMedicineRepository = orderedMedicineRepository;
    }

    public List<PrescriptionDto> getPrescriptions(String cnp) {
        return prescriptionRepository.findAll()
                .stream()
                .filter(prescription -> prescription.getPatient().getCnp().equals(cnp))
                .map(prescriptionMapper::convertSource)
                .collect(Collectors.toList());
    }


    private void orderPrescription(Prescription prescription) {

        User user = prescription.getPatient().getUser();
        List<SearchMedicineRequest> collect1 = Arrays.stream(prescription.getItems().split(";")).map(s -> {
            String[] split = s.split(",");
            SearchMedicineRequest searchMedicineRequest = new SearchMedicineRequest();
            searchMedicineRequest.setActiveSubstance(split[0]);
            searchMedicineRequest.setAmountOfActiveSubstance(split[1]);
            return searchMedicineRequest;
        }).collect(Collectors.toList());
        MedicineSearchRequest medicineSearchRequest = new MedicineSearchRequest().setPreSearchedMedicines(collect1);
        //Checking the inventory
        List<MedicineSearchResponse> collect = pharmacyRepository.findAll()
                .stream()
                .map(pharmacy -> {
                    HttpEntity<MedicineSearchRequest> request = new HttpEntity<>(medicineSearchRequest);
                    return restTemplate.postForObject(pharmacy.getSalesChannel(), request, MedicineSearchResponse.class);
                })
                .sorted((o1, o2) -> {
                    long o1MedicinesFound = getSearchMedicineResponseCount(o1.getSearchMedicineResponses());
                    long o2MedicinesFound = getSearchMedicineResponseCount(o2.getSearchMedicineResponses());
                    return Long.compare(o1MedicinesFound, o2MedicinesFound);
                })
                .collect(Collectors.toList());
        MedicineSearchResponse medicineSearchResponse = collect.get(0);
        List<MedicineResponse> medicineResponse = medicineSearchResponse.getSearchMedicineResponses().stream()
                .map(searchMedicineResponse -> searchMedicineResponse.getMedicines().get(0))
                .collect(Collectors.toList());

        //Ordering
        List<MedicineOrderRequest> medicineOrderRequests = medicineResponse.stream().map(medicineResponse1 -> {
            MedicineOrderRequest medicineOrderRequest = new MedicineOrderRequest();
            medicineOrderRequest.setResourceId(medicineResponse1.getResourceId());
            medicineOrderRequest.setInventory(String.valueOf(medicineResponse1.getInventory()));
            medicineOrderRequest.setPharmacyId(medicineResponse1.getPharmacyId());
            return medicineOrderRequest;
        }).collect(Collectors.toList());
        Pharmacy pharmacy = pharmacyRepository.findAll().get(0);
        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setMedicineOrders(medicineOrderRequests);
        orderRequest.setAddress(user.getAddress());
        orderRequest.setEmail(user.getEmail());
        HttpEntity<OrderRequest> request = new HttpEntity<>(orderRequest);
        restTemplate.postForObject(pharmacy.getSalesChannel() + "/order", request, MedicineSearchResponse.class);

        // Save order
        Order order = new Order();
        order.setDoctor(prescription.getPatient().getDoctor());
        order.setPrescription(prescription);
        final Order createdOrder = orderRepository.save(order);
        List<OrderedMedicine> medicineList = medicineResponse.stream()
                .map(medicineResponse1 -> {
                    OrderedMedicine orderedMedicine = new OrderedMedicine();
                    orderedMedicine.setOrder(createdOrder);
                    orderedMedicine.setPharmacy(pharmacy);
                    orderedMedicine.setPrice((double) medicineResponse1.getPrice());
                    orderedMedicine.setQuantity(1);
                    orderedMedicine.setTitle(medicineResponse1.getTitle());
                    orderedMedicine.setResourceId(medicineResponse1.getResourceId());
                    return orderedMedicineRepository.save(orderedMedicine);
                }).collect(Collectors.toList());
        createdOrder.setMedicineList(medicineList);
        prescription.getOrders().add(order);
    }

    public void createPrescription(PrescriptionDto prescriptionDto) {
        Prescription prescription = prescriptionMapper.convertTarget(prescriptionDto);
        prescription.setPatient(patientRepository.findById(prescriptionDto.getPatientCnp()).get());
        Prescription save = prescriptionRepository.save(prescription);
        orderPrescription(save);
    }

    private long getSearchMedicineResponseCount(List<SearchMedicineResponse> searchMedicineResponsesList) {
        return searchMedicineResponsesList.stream()
                .map(searchMedicineResponses -> searchMedicineResponses.getMedicines().size() > 1)
                .count();
    }
}
