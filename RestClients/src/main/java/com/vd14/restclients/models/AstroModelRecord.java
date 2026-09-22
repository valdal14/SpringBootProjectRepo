package com.vd14.restclients.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record AstroModelRecord(
        @JsonProperty("people")
        List<Astronaut> astronauts,
        @JsonProperty("number")
        int numbers,
        String message
) { }
