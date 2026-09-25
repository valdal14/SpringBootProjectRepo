package com.vd14.persistence.controllers;

import com.vd14.persistence.models.UniClass;
import com.vd14.persistence.services.UniRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UniRestController {
    private final UniRestService uniRestService;

    @Autowired
    public UniRestController(UniRestService uniRestService) {
        this.uniRestService = uniRestService;
    }

    @GetMapping("/unijpa")
    public List<UniClass> findAll() {
        return this.uniRestService.findAll();
    }
}
