package com.smarthack.sudo.service;

import com.smarthack.sudo.converters.impl.PharmacyMapper;
import com.smarthack.sudo.converters.impl.UserMapper;
import com.smarthack.sudo.domain.Pharmacy;
import com.smarthack.sudo.domain.User;
import com.smarthack.sudo.dto.PharmacyDto;
import com.smarthack.sudo.dto.UserDto;
import com.smarthack.sudo.repository.PharmacyRepository;
import com.smarthack.sudo.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class PharmacyService extends BasicService<Pharmacy, PharmacyDto, String> {

    public PharmacyService(PharmacyMapper pharmacyMapper, PharmacyRepository pharmacyRepository) {
        super(pharmacyRepository, pharmacyMapper);
    }

}
