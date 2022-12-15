package com.mycode.sopsdemo.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.mycode.sopsdemo.entity.Parameter;
import com.mycode.sopsdemo.service.ParameterService;
import com.mycode.sopsdemo.service.SOPServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/parameter")
public class ParameterController {

    private final SOPServices<Parameter> service;

    @Autowired
    public ParameterController(SOPServices<Parameter> service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public Parameter getParameter(@PathVariable UUID id) {
        return service.findById(id);
    }

    @PostMapping("/")
    public Parameter addParameter(@RequestBody JsonNode data) {
        Parameter param = new Parameter();
        param.setData(data);
        return service.save(param);
    }

    @DeleteMapping("/{id}")
    public void deleteParameter(@PathVariable UUID id) {
        service.deleteById(id);
    }
}
