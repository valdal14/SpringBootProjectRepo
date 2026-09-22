package com.vd14.restclients.controllers;

import com.vd14.restclients.models.AstroModelRecord;
import com.vd14.restclients.services.AstroInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AstroHttpInterfaceController {
    private final AstroInterface astroInterface;

    @Autowired
    public AstroHttpInterfaceController(AstroInterface astroInterface) {
        this.astroInterface = astroInterface;
    }

    @GetMapping("/astroexchange")
    public AstroModelRecord getRecord() {
        return astroInterface.getAstroExchange();
    }
}
