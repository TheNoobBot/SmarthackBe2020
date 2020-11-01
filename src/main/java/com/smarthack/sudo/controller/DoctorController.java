package com.smarthack.sudo.controller;

import com.smarthack.sudo.dto.DoctorDto;
import com.smarthack.sudo.dto.PatientDto;
import com.smarthack.sudo.service.DoctorService;
import com.smarthack.sudo.service.PatientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping("/approve")
    DoctorDto saveAsDoctor(@RequestBody DoctorDto doctorDto) {
        return doctorService.saveAsDoctor(doctorDto);
    }

}
