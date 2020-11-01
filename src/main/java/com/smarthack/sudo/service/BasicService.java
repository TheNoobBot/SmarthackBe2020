package com.smarthack.sudo.service;

import com.smarthack.sudo.converters.BasicMapper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public class BasicService<DAO, DTO, KEY> {

    protected final JpaRepository<DAO, KEY> repository;
    protected final BasicMapper<DAO, DTO> mapper;

    public BasicService(JpaRepository<DAO, KEY> repository, BasicMapper<DAO, DTO> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public DTO create(DTO dto) {
        DAO dao = mapper.convertTarget(dto);
        DAO save = repository.save(dao);
        return mapper.convertSource(save);
    }

    public List<DTO> findAll() {
        return mapper.convertSource(repository.findAll());
    }

    public DTO findOne(KEY key) {
        Optional<DAO> dao = repository.findById(key);
        if (dao.isPresent()) {
            return mapper.convertSource(dao.get());
        }
        throw new IllegalArgumentException("Not found");
    }
}
