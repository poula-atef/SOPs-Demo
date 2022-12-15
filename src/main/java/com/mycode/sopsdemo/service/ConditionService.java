package com.mycode.sopsdemo.service;

import com.mycode.sopsdemo.entity.Condition;
import com.mycode.sopsdemo.entity.SOP;
import com.mycode.sopsdemo.repository.ConditionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ConditionService implements SOPServices<Condition> {

    private final ConditionRepository conditionRepo;
    private final SOPService sopService;

    @Autowired
    public ConditionService(ConditionRepository conditionRepo, SOPService sopService) {
        this.conditionRepo = conditionRepo;
        this.sopService = sopService;
    }

    @Override
    public Condition findById(UUID id) {
        Optional<Condition> result = conditionRepo.findById(id);
        if(result.isEmpty())
            throw new RuntimeException("Condition Not Found !!");
        System.out.println("Condition SOPs: --------------------------");
        System.out.println(result.get().getSops());
        System.out.println("-------------------------------------------------------------------");
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

    public List<SOP> getAllSOPs(UUID id) {
        Condition condition = findById(id);
        return condition.getSops();
    }

    public Condition addSOPToCondition(UUID sopId, UUID conditionId) {
        Condition condition = findById(conditionId);
        SOP sop = sopService.findById(sopId);
        condition.addSOP(sop);
        conditionRepo.save(condition);
        return condition;
    }
}
