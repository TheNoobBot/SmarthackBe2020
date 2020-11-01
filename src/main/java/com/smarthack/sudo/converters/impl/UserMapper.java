package com.smarthack.sudo.converters.impl;

import com.smarthack.sudo.converters.BasicMapper;
import com.smarthack.sudo.domain.User;
import com.smarthack.sudo.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper extends BasicMapper<User, UserDto> {
    private final ModelMapper modelMapper;

    public UserMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDto convertSource(User user) {
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public User convertTarget(UserDto userDto) {
        return modelMapper.map(userDto, User.class);
    }
}
