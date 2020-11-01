package com.smarthack.sudo.converters.impl;

import com.smarthack.sudo.converters.BasicMapper;
import com.smarthack.sudo.domain.Pharmacy;
import com.smarthack.sudo.dto.PharmacyDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PharmacyMapper extends BasicMapper<Pharmacy, PharmacyDto> {
    private final ModelMapper modelMapper;

    public PharmacyMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public PharmacyDto convertSource(Pharmacy pharmacy) {
        return modelMapper.map(pharmacy, PharmacyDto.class);
    }

    @Override
    public Pharmacy convertTarget(PharmacyDto pharmacyDto) {
        return modelMapper.map(pharmacyDto, Pharmacy.class);
    }
}
