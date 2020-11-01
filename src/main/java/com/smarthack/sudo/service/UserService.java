package com.smarthack.sudo.service;

import com.smarthack.sudo.converters.impl.UserMapper;
import com.smarthack.sudo.domain.Doctor;
import com.smarthack.sudo.domain.User;
import com.smarthack.sudo.dto.UserDto;
import com.smarthack.sudo.dto.vm.ManagedUserVM;
import com.smarthack.sudo.repository.DoctorRepository;
import com.smarthack.sudo.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService extends BasicService<User, UserDto, String> {

    private final PasswordEncoder passwordEncoder;
    private final DoctorRepository doctorRepository;

    public UserService(UserMapper userMapper, UserRepository userRepository, PasswordEncoder passwordEncoder, DoctorRepository doctorRepository) {
        super(userRepository, userMapper);
        this.passwordEncoder = passwordEncoder;
        this.doctorRepository = doctorRepository;
    }

    @Override
    public UserDto findOne(String s) {
        UserDto one = super.findOne(s);
        Optional<Doctor> byId = doctorRepository.findById(s);
        if(byId.isPresent()) {
            one.setEdoctor(true);
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
