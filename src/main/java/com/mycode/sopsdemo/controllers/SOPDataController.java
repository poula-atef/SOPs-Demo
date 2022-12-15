package com.mycode.sopsdemo.controllers;

import com.mycode.sopsdemo.entity.SOPData;
import com.mycode.sopsdemo.service.SOPDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("sop_data")
public class SOPDataController {

    private final SOPDataService service;

    @Autowired
    public SOPDataController(SOPDataService service) {
        this.service = service;
    }


    @GetMapping("/{id}")
    public SOPData getSOPData(@PathVariable UUID id) {
        return service.findById(id);
    }

    @PostMapping("/")
    public SOPData addSOPData(@RequestBody SOPData data) {
        return service.save(data);
    }

    @DeleteMapping("/{id}")
    public void deleteSOPData(@PathVariable UUID id) {
        service.deleteById(id);
    }

    @PostMapping("/addParameter")
    public SOPData addParameterToSOPData(@RequestParam(name = "sopDataId") UUID sopId, @RequestParam(name = "parameterId") UUID parameterId) {
        return service.addParameter(sopId, parameterId);
    }
}
