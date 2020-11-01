package com.smarthack.sudo.converters.impl;

import com.smarthack.sudo.converters.BasicMapper;
import com.smarthack.sudo.domain.Prescription;
import com.smarthack.sudo.dto.PrescriptionDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PrescriptionMapper extends BasicMapper<Prescription, PrescriptionDto> {
    private final ModelMapper modelMapper;

    public PrescriptionMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public PrescriptionDto convertSource(Prescription prescription) {
        return modelMapper.map(prescription, PrescriptionDto.class);
    }

    @Override
    public Prescription convertTarget(PrescriptionDto prescriptionDto) {
        return modelMapper.map(prescriptionDto, Prescription.class);
    }
}
