package com.smarthack.sudo.converters;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public abstract class BasicMapper<SOURCE, TARGET> {

    public abstract TARGET convertSource(SOURCE source);

    public abstract SOURCE convertTarget(TARGET target);

    public List<TARGET> convertSource(List<SOURCE> source) {
        return source.stream().map(this::convertSource).collect(Collectors.toList());
    }

    public List<SOURCE> convertTarget(List<TARGET> target) {
        return target.stream().map(this::convertTarget).collect(Collectors.toList());
    }

}
