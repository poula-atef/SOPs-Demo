package com.mycode.sopsdemo.controllers;

import com.mycode.sopsdemo.entity.Condition;
import com.mycode.sopsdemo.service.ConditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/condition")
public class ConditionController {

    private final ConditionService service;

    @Autowired
    public ConditionController(ConditionService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public Condition getCondition(@PathVariable UUID id) {
        return service.findById(id);
    }

    @PostMapping("/")
    public Condition addCondition(@RequestBody Condition data) {
        return service.save(data);
    }

    @DeleteMapping("/{id}")
    public void deleteCondition(@PathVariable UUID id) {
        service.deleteById(id);
    }

}
