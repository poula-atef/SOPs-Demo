package com.mycode.sopsdemo.service;

import com.mycode.sopsdemo.entity.Condition;
import com.mycode.sopsdemo.repository.ConditionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ConditionService implements SOPServices<Condition> {

    private final ConditionRepository conditionRepo;


    @Autowired
    public ConditionService(ConditionRepository conditionRepo) {
        this.conditionRepo = conditionRepo;
    }


    @Override
    public Condition findById(UUID id) {
        Optional<Condition> result = conditionRepo.findById(id);
        if(result.isEmpty())
            throw new RuntimeException("Condition Not Found !!");
        return result.get();
    }

    @Override
    public void deleteById(UUID id) {
        conditionRepo.deleteById(id);
    }

    @Override
    public Condition save(Condition condition) {
        return conditionRepo.save(condition);
    }
}
