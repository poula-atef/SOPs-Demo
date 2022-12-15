package com.mycode.sopsdemo.controllers;

import com.mycode.sopsdemo.entity.SOP;
import com.mycode.sopsdemo.service.SOPService;
import com.mycode.sopsdemo.service.SOPServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/sop")
public class SOPController {

    private final SOPService service;

    @Autowired
    public SOPController(SOPService service) {
        this.service = service;
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
}
