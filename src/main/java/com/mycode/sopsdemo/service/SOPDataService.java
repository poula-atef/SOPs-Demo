package com.mycode.sopsdemo.service;

import com.mycode.sopsdemo.entity.Parameter;
import com.mycode.sopsdemo.entity.SOPData;
import com.mycode.sopsdemo.repository.ParameterRepository;
import com.mycode.sopsdemo.repository.SOPDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class SOPDataService implements SOPServices<SOPData> {

    private SOPDataRepository dataRepo;
    private ParameterService parameterService;

    @Autowired
    public SOPDataService(SOPDataRepository dataRepo, ParameterService parameterService) {
        this.dataRepo = dataRepo;
        this.parameterService = parameterService;
    }

    @Override
    public SOPData findById(UUID id) {
        Optional<SOPData> result = dataRepo.findById(id);
        if(result.isEmpty())
            throw new RuntimeException("Parameter Not Found !!");
        return result.get();
    }

    @Override
    public void deleteById(UUID id) {
        dataRepo.deleteById(id);
    }

    @Override
    public SOPData save(SOPData param) {
        return dataRepo.save(param);
    }

    public SOPData addParameter(UUID sopId, UUID parameterId) {

        Parameter parameter = parameterService.findById(parameterId);

        SOPData data = findById(sopId);

        data.setParameter(parameter);

        dataRepo.save(data);

        return data;
    }
}