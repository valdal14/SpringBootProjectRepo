package com.vd14.restclients.repository;

import com.vd14.restclients.models.AstroModelRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;

@Repository
public class AstroRestRepoImplementation implements AstroRepository {
    private final static String ENDPOINT_URL = "http://api.open-notify.org/astros.json";
    private final WebClient webClient;

    @Autowired
    public AstroRestRepoImplementation(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public AstroModelRecord getRecord() {
        return webClient.get()
                .uri(ENDPOINT_URL)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(AstroModelRecord.class)
                .block(Duration.ofSeconds(3));
    }
}
