package com.vd14.restclients.repository;

import com.vd14.restclients.models.AstroModelRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClient;

@Repository
public class AstroRepoImplementation implements AstroRepository {
    private final static String ENDPOINT_URL = "http://api.open-notify.org/astros.json";
    @Autowired
    private RestClient restClient;

    @Override
    public AstroModelRecord getRecord() {

        return restClient
                .get()
                .uri(ENDPOINT_URL)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(AstroModelRecord.class);
    }
}
