package com.vd14.persistence.controllers;

import com.vd14.persistence.models.UniClass;
import com.vd14.persistence.services.UniSDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UniSDController {
    private final UniSDService uniSDService;

    @Autowired
    public UniSDController(UniSDService uniSDService) {
        this.uniSDService = uniSDService;
    }

    @GetMapping("/unisd")
    public List<UniClass> findAll() {
        return uniSDService.findAll();
    }
}
