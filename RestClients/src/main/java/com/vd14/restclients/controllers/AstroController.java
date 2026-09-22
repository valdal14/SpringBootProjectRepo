package com.vd14.restclients.controllers;

import com.vd14.restclients.models.AstroModelRecord;
import com.vd14.restclients.services.AstroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AstroController {
    private final AstroService astroService;

    @Autowired
    public AstroController(AstroService astroService) {
        this.astroService = astroService;
    }

    @GetMapping("/astro")
    public String getRecord(Model model) {
        AstroModelRecord record = this.astroService.getRecords();
        model.addAttribute("message", record.message());
        model.addAttribute("numbers", record.numbers());
        model.addAttribute("astronauts", record.astronauts());

        return "howManyAstronaut";
    }
}
