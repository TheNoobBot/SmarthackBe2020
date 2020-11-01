package com.smarthack.sudo.converters.impl;

import com.smarthack.sudo.converters.BasicMapper;
import com.smarthack.sudo.domain.Doctor;
import com.smarthack.sudo.dto.DoctorDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DoctorMapper extends BasicMapper<Doctor, DoctorDto> {
    private final ModelMapper modelMapper;

    public DoctorMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public DoctorDto convertSource(Doctor doctor) {
        return modelMapper.map(doctor, DoctorDto.class);
    }

    @Override
    public Doctor convertTarget(DoctorDto doctorDto) {
        return modelMapper.map(doctorDto, Doctor.class);
    }
}
