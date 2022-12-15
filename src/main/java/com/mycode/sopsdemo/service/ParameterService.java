package com.mycode.sopsdemo.service;

import com.mycode.sopsdemo.entity.Parameter;
import com.mycode.sopsdemo.repository.ParameterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ParameterService implements SOPServices<Parameter> {

    @Autowired
    private ParameterRepository repo;

    @Override
    public Parameter findById(UUID id) {
        Optional<Parameter> result = repo.findById(id);
        if(result.isEmpty())
            throw new RuntimeException("Parameter Not Found !!");
        return result.get();
    }

    @Override
    public void deleteById(UUID id) {
        repo.deleteById(id);
    }

    @Override
    public Parameter save(Parameter param) {
        return repo.save(param);
    }

}
