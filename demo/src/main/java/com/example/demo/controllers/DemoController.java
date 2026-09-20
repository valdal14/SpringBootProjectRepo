package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DemoController {
    // maps http://localhost:8080/hello?name=Val
    @GetMapping("/hello")
    public String welcomeMessage(
            @RequestParam(defaultValue = "SpringBoot App") String name,
            Model model
    ) {
        // takes the optional 'name' and add it to the model.
        model.addAttribute("user", name);
        // forward the request to /src/main/resources/templates/welcome.html
        return "welcome";
    }
}
