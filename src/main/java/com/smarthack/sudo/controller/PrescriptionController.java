package com.smarthack.sudo.controller;

import com.smarthack.sudo.domain.Prescription;
import com.smarthack.sudo.dto.PrescriptionDto;
import com.smarthack.sudo.prescriptions.model.requests.MedicineSearchRequest;
import com.smarthack.sudo.service.PrescriptionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/prescription")
public class PrescriptionController {

    private final PrescriptionService prescriptionService;

    public PrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    @PostMapping
    private void checkPrescription(@RequestBody PrescriptionDto prescriptionDto) {
        prescriptionService.createPrescription(prescriptionDto);
    }

    @GetMapping("/{cnp}")
    private List<PrescriptionDto> getPrescriptions(@PathVariable String cnp) {
        return prescriptionService.getPrescriptions(cnp);
    }

}
