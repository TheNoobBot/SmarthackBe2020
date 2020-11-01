package com.smarthack.sudo.service;

import com.smarthack.sudo.dto.OrderDto;
import com.smarthack.sudo.dto.OrderedMedicineDto;
import com.smarthack.sudo.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderDto> getOrders(String cnp) {
        return orderRepository.findAll().stream().filter(order -> order.getPrescription().getPatient().getCnp().equals(cnp))
                .map(order ->
                {
                    List<OrderedMedicineDto> collect = order.getMedicineList().stream()
                            .map(orderedMedicine ->
                                    new OrderedMedicineDto().setId(orderedMedicine.getId())
                                            .setPharmacyName(orderedMedicine.getPharmacy().getName())
                                            .setPrice(orderedMedicine.getPrice())
                                            .setQuantity(orderedMedicine.getQuantity())
                                            .setResourceId(orderedMedicine.getResourceId())
                                            .setTitle(orderedMedicine.getTitle())
                            )
                            .collect(Collectors.toList());
                return new OrderDto().setMedicines(collect).setId(order.getId());
                })
                .collect(Collectors.toList());
    }

}
