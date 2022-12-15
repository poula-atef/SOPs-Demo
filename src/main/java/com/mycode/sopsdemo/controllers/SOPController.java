package com.mycode.sopsdemo.controllers;

import com.mycode.sopsdemo.entity.Condition;
import com.mycode.sopsdemo.entity.SOP;
import com.mycode.sopsdemo.service.ConditionService;
import com.mycode.sopsdemo.service.SOPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/sop")
public class SOPController {

    private final SOPService service;
    private final ConditionService conditionService;

    @Autowired
    public SOPController(SOPService service, ConditionService conditionService) {
        this.service = service;
        this.conditionService = conditionService;
    }


    @GetMapping("/{id}")
    public SOP getSOP(@PathVariable UUID id) {
        return service.findById(id);
    }

    @PostMapping("/")
    public SOP addSOP(@RequestParam("sopId") UUID sopId,
                      @RequestParam("parentId") UUID parentId,
                      @RequestParam("order") Integer order) {
        return service.save(sopId, parentId, order);
    }

    @DeleteMapping("/{id}")
    public void deleteParameter(@PathVariable UUID id) {
        service.deleteById(id);
    }

    @GetMapping("/conditions/{id}")
    public List<Condition> getSOPConditions(@PathVariable UUID id) {
        return service.getAllConditions(id);
    }

    @PostMapping("/addCondition")
    public void addSOPToCondition(@RequestParam("conditionId") UUID conditionId,
                                  @RequestParam("sopId") UUID sopId) {
        conditionService.addSOPToCondition(sopId, conditionId);
    }

}
