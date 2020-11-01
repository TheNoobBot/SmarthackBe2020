package com.smarthack.sudo.controller;

import com.smarthack.sudo.domain.Patient;
import com.smarthack.sudo.dto.PatientDto;
import com.smarthack.sudo.service.PatientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {
    private static final List<String> ALLOWED_ORDERED_PROPERTIES = Collections.unmodifiableList(Arrays.asList("id", "login", "firstName", "lastName", "email", "activated", "langKey"));

    private final Logger log = LoggerFactory.getLogger(PatientController.class);

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/doctor/{doctorCnp}")
    List<PatientDto> getPatientsForDoctor(@PathVariable String doctorCnp) {
        return patientService.getPatientsForDoctor(doctorCnp);
    }

    @PostMapping
    PatientDto saveAsPatient(@RequestBody PatientDto patientDto) {
        PatientDto patientDto1 = patientService.saveAsPatient(patientDto);
        return patientDto1;
    }

}
