package com.vd14.restclients.controllers;

import com.vd14.restclients.models.AstroModelRecord;
import com.vd14.restclients.models.Astronaut;
import com.vd14.restclients.services.AstroService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(AstroController.class)
class AstroControllerTest {

    @Autowired
    private MockMvc mvc;

    // Only mock the direct dependency of the AstroController
    @MockitoBean
    private AstroService astroService;

    @Test
    public void testAutowiringMockMVC() {
        assertNotNull(mvc);
    }

    @Test
    public void testGetRecord() throws Exception {
        // Create the mock data
        List<Astronaut> mockedAstronauts = List.of(
                new Astronaut("Neil Armstrong", "Apollo 11"),
                new Astronaut("Buzz Aldrin", "Apollo 11")
        );

        AstroModelRecord mockRecord = new AstroModelRecord(mockedAstronauts, 2, "success");

        // Instruct the mock service to return the mocked data
        Mockito.when(astroService.getRecords()).thenReturn(mockRecord);

        // Execute the request
        mvc.perform(get("/astro"))
                .andExpect(status().isOk())
                .andExpect(view().name("howManyAstronaut"))
                .andExpect(model().attribute("message", "success"))
                .andExpect(model().attribute("numbers", 2))
                .andExpect(model().attribute("astronauts", mockedAstronauts));
    }
}