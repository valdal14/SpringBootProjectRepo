package com.vd14.restclients.services;

import com.vd14.restclients.models.AstroModelRecord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AstroInterfaceTest {
    @Autowired
    private AstroInterface astroInterface;

    @Test
    void getAstroExchange() {
        AstroModelRecord astroExchange = astroInterface.getAstroExchange();
        int count = astroExchange.numbers();
        String expectedMessage = "success";

        Assertions.assertAll(
                ()-> assertTrue(count > 0),
                ()-> assertEquals(expectedMessage, astroExchange.message())
        );
    }
}