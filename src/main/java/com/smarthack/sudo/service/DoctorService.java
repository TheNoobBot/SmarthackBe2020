package com.smarthack.sudo.service;

import com.smarthack.sudo.converters.impl.DoctorMapper;
import com.smarthack.sudo.domain.Doctor;
import com.smarthack.sudo.domain.User;
import com.smarthack.sudo.domain.enumeration.DoctorStatus;
import com.smarthack.sudo.dto.DoctorDto;
import com.smarthack.sudo.dto.PatientDto;
import com.smarthack.sudo.repository.DoctorRepository;
import com.smarthack.sudo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorService extends BasicService<Doctor, DoctorDto, String> {

    private final UserRepository userRepository;

    public DoctorService(DoctorMapper doctorMapper, DoctorRepository doctorRepository, UserRepository userRepository) {
        super(doctorRepository, doctorMapper);
        this.userRepository = userRepository;
    }

    public DoctorDto saveAsDoctor(DoctorDto doctorDto) {
        Optional<User> byId = userRepository.findById(doctorDto.getCnp());
        Doctor doctor = new Doctor();
        doctor.setPic(doctorDto.getPic());
        doctor.setStatus(DoctorStatus.CONFIRMED);
        doctor.setUser(byId.get());
        Doctor save = super.repository.save(doctor);
        return super.mapper.convertSource(save);
    }
}
