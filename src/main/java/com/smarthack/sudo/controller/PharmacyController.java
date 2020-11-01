package com.smarthack.sudo.controller;

import com.smarthack.sudo.dto.PharmacyDto;
import com.smarthack.sudo.service.PharmacyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pharmacies")
public class PharmacyController {

    private final PharmacyService pharmacyService;

    public PharmacyController(PharmacyService pharmacyService) {
        this.pharmacyService = pharmacyService;
    }

    @PostMapping
    PharmacyDto createPharmacy(@RequestBody PharmacyDto pharmacyDto) {
        return pharmacyService.create(pharmacyDto);
    }

    @GetMapping
    List<PharmacyDto> getPharmacies() {
        return pharmacyService.findAll();
    }
}
