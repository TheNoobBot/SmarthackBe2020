package com.smarthack.sudo.service;

import com.smarthack.sudo.converters.impl.PatientMapper;
import com.smarthack.sudo.converters.impl.UserMapper;
import com.smarthack.sudo.domain.Doctor;
import com.smarthack.sudo.domain.Patient;
import com.smarthack.sudo.domain.User;
import com.smarthack.sudo.dto.PatientDto;
import com.smarthack.sudo.dto.UserDto;
import com.smarthack.sudo.repository.DoctorRepository;
import com.smarthack.sudo.repository.PatientRepository;
import com.smarthack.sudo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService extends BasicService<Patient, PatientDto, String> {

    private final PatientRepository patientRepository;
    private final UserRepository userRepository;
    private final DoctorRepository doctorRepository;
    private final UserMapper userMapper;

    public PatientService(PatientMapper patientMapper, PatientRepository patientRepository, UserRepository userRepository, DoctorRepository doctorRepository,
            UserMapper userMapper) {
        super(patientRepository, patientMapper);
        this.patientRepository = patientRepository;
        this.userRepository = userRepository;
        this.doctorRepository = doctorRepository;
        this.userMapper = userMapper;
    }

    public List<UserDto> getPatientsForDoctor(String doctorCnp) {
        List<User> collect = patientRepository.findAll()
                .stream()
                .filter(patient -> patient.getDoctor().getCnp().equals(doctorCnp))
                .map(Patient::getUser)
                .collect(Collectors.toList());
        return userMapper.convertSource(collect);
    }

    public PatientDto saveAsPatient(PatientDto patientDto) {
        User user = userRepository.findById(patientDto.getCnp()).get();
        Doctor doctor = doctorRepository.findById(patientDto.getDoctorCnp()).get();
        Patient patient = new Patient();
        patient.setDoctor(doctor);
        patient.setHealthInsuranceId(patientDto.getHealthInsuranceId());
        patient.setUser(user);
        Patient save = patientRepository.save(patient);
        return super.mapper.convertSource(save);
    }

    public UserDto getDoctorForPatient(String cnp) {
        return userMapper.convertSource(patientRepository.findById(cnp).get().getDoctor().getUser());
    }
}
