package com.example.demo.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(DemoController.class)
public class DemoControllerMockMVCTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testAutowiringMockMVC() {
        Assertions.assertNotNull(mockMvc);
    }
}
