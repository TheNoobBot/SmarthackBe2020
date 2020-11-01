package com.smarthack.sudo.service;

import com.smarthack.sudo.converters.impl.UserMapper;
import com.smarthack.sudo.domain.Doctor;
import com.smarthack.sudo.domain.Patient;
import com.smarthack.sudo.domain.User;
import com.smarthack.sudo.dto.UserDto;
import com.smarthack.sudo.dto.vm.ManagedUserVM;
import com.smarthack.sudo.repository.DoctorRepository;
import com.smarthack.sudo.repository.PatientRepository;
import com.smarthack.sudo.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService extends BasicService<User, UserDto, String> {

    private final PasswordEncoder passwordEncoder;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    public UserService(UserMapper userMapper, UserRepository userRepository, PasswordEncoder passwordEncoder, DoctorRepository doctorRepository, PatientRepository patientRepository) {
        super(userRepository, userMapper);
        this.passwordEncoder = passwordEncoder;
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }

    public List<UserDto> findAll(String cnp, boolean patientFilter) {
        List<User> all = repository.findAll().stream().filter(user -> user.getCnp().contains(cnp)).collect(Collectors.toList());
        Map<String, UserDto> userMap = all.stream().collect(Collectors.toMap(User::getCnp, mapper::convertSource));
        doctorRepository.findAll()
                .stream().filter(user -> user.getCnp().contains(cnp)).collect(Collectors.toList())
                .forEach(doctor -> userMap.get(doctor.getCnp()).setEdoctor(true));
        patientRepository.findAll()
                .stream().filter(user -> user.getCnp().contains(cnp)).collect(Collectors.toList())
                .forEach(patient -> userMap.get(patient.getCnp()).setEpacient(true));
        List<UserDto> users = new ArrayList<>(userMap.values());
        if(patientFilter) {
             users = users.stream().filter(userDto -> !(userDto.isEpacient() || userDto.isEdoctor())).collect(Collectors.toList());
        }
        return users;
    }

    @Override
    public UserDto findOne(String s) {
        UserDto one = super.findOne(s);
        Optional<Doctor> doctorOptional = doctorRepository.findById(s);
        Optional<Patient> patientOptional = patientRepository.findById(s);
        if(doctorOptional.isPresent()) {
            one.setEdoctor(true);
        }
        if(patientOptional.isPresent()) {
            one.setEpacient(true);
        }
        return one;
    }

    public UserDto registerUser(ManagedUserVM managedUserVM, String password) {
        User user = super.mapper.convertTarget(managedUserVM);
        user.setPassword(passwordEncoder.encode(password));
        User save = super.repository.save(user);
        return super.mapper.convertSource(save);
    }
}
