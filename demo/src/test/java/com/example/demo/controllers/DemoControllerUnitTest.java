package com.example.demo.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ConcurrentModel;

import static org.junit.jupiter.api.Assertions.*;

class DemoControllerUnitTest {

    @Test
    void welcomeMessageProducesTheExpectedMessageAndModelProperty() {
        DemoController demoController = new DemoController();
        // Instance of a Model from the library
        ConcurrentModel model = new ConcurrentModel();

        String user = "Val";
        String expectedReturnPath = "welcome";
        String actualReturnPath = demoController.welcomeMessage(user, model);
        assertEquals(expectedReturnPath, actualReturnPath);
        assertEquals(user, model.get("user"));
    }
}