package com.smarthack.sudo.converters.impl;

import com.smarthack.sudo.converters.BasicMapper;
import com.smarthack.sudo.domain.Patient;
import com.smarthack.sudo.dto.PatientDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PatientMapper extends BasicMapper<Patient, PatientDto> {

    private final ModelMapper modelMapper;

    public PatientMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public PatientDto convertSource(Patient patient) {
        return modelMapper.map(patient, PatientDto.class);
    }

    @Override
    public Patient convertTarget(PatientDto patientDto) {
        return modelMapper.map(patientDto, Patient.class);
    }
}
