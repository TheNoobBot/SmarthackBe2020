package com.smarthack.sudo.converters.impl;

import com.smarthack.sudo.converters.BasicMapper;
import com.smarthack.sudo.domain.OrderedMedicine;
import com.smarthack.sudo.dto.OrderedMedicineDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class OrderedMedicineMapper extends BasicMapper<OrderedMedicine, OrderedMedicineDto> {
    private final ModelMapper modelMapper;

    public OrderedMedicineMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public OrderedMedicineDto convertSource(OrderedMedicine orderedMedicine) {
        return modelMapper.map(orderedMedicine, OrderedMedicineDto.class);
    }

    @Override
    public OrderedMedicine convertTarget(OrderedMedicineDto orderedMedicineDto) {
        return modelMapper.map(orderedMedicineDto, OrderedMedicine.class);
    }
}
