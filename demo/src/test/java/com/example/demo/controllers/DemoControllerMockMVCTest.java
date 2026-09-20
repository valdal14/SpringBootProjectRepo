package com.example.demo.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DemoController.class)
public class DemoControllerMockMVCTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testAutowiringMockMVC() {
        assertNotNull(mockMvc);
    }

    @Test
    public void testWelcomeMessageWithoutQueryString() throws Exception {
        // .perform take a Request Builder, in this case I will use get
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(view().name("welcome"))
                .andExpect(model().attribute("user", "SpringBoot App"));
    }
}
