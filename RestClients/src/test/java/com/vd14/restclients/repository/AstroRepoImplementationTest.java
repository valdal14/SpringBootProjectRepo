package com.vd14.restclients.repository;

import com.vd14.restclients.models.AstroModelRecord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureRestTestClient
class AstroRepoImplementationTest {

    @Autowired
    private AstroRepoImplementation astroRepoImplementation;

    @Test
    void getRecord() {
        AstroModelRecord record = astroRepoImplementation.getRecord();
        String expectedMessage = "success";

        Assertions.assertAll(
                () -> assertTrue((record.numbers() > 0), "Expected astronauts in space"),
                () -> assertEquals(expectedMessage, record.message())
        );
    }
}