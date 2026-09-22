package com.vd14.restclients.controllers;

import com.vd14.restclients.models.AstroModelRecord;
import com.vd14.restclients.services.AstroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AstroRestFulController {
    private final AstroService astroService;

    @Autowired
    public AstroRestFulController(AstroService astroService) {
        this.astroService = astroService;
    }

    @GetMapping("/restastro")
    public AstroModelRecord getRecord() {
        return astroService.getRecords();
    }
}
