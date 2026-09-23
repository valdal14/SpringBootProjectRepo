package com.vd14.persistence.controllers;

import com.vd14.persistence.models.University;
import com.vd14.persistence.services.UniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UniController {
    private final UniService uniService;

    @Autowired
    public UniController(UniService uniService) {
        this.uniService = uniService;
    }

    @GetMapping("/uni")
    public String getAllUniversities(Model model) {
        List<University> universities = this.uniService.findAll();
        model.addAttribute("universities", universities);
        return "universities";
    }
}
