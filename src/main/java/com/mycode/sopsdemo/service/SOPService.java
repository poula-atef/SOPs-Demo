package com.mycode.sopsdemo.service;

import com.mycode.sopsdemo.entity.Condition;
import com.mycode.sopsdemo.entity.SOP;
import com.mycode.sopsdemo.entity.SOPData;
import com.mycode.sopsdemo.repository.SOPRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SOPService implements SOPServices<SOP>{

    private final SOPRepository sopRepo;
    private final SOPDataService sopDataService;

    @Autowired
    public SOPService(SOPRepository sopRepo, SOPDataService sopDataService) {
        this.sopRepo = sopRepo;
        this.sopDataService = sopDataService;
    }


    @Override
    public SOP findById(UUID id) {
        Optional<SOP> result = sopRepo.findById(id);
        if(result.isEmpty())
            throw new RuntimeException("Parameter Not Found !!");
        System.out.println("SOP Conditions: --------------------------");
        System.out.println(result.get().getConditions());
        System.out.println("-------------------------------------------------------------------");
        return result.get();
    }

    @Override
    public void deleteById(UUID id) {
        sopRepo.deleteById(id);
    }

    @Override
    public SOP save(SOP param) {
        return sopRepo.save(param);
    }


    public SOP save(UUID sopId, UUID parentId, Integer order) {

        SOPData sopData = sopDataService.findById(sopId);
        SOPData sopParentData = sopDataService.findById(parentId);

        SOP sop = new SOP();
        sop.setSOP(sopData);
        sop.setParent(sopParentData);
        sop.setOrder(order);

        return sopRepo.save(sop);
    }

    public List<Condition> getAllConditions(UUID id) {
        SOP sop = findById(id);
        return sop.getConditions();
    }


}
