package com.vd14.restclients.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.restclient.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder, @Value("${astro.base.url}") String baseUrl) {
        return builder.baseUri(baseUrl).build();
    }

    @Bean
    public RestTemplate astroRestTemplate(RestTemplateBuilder builder) {
        return builder.baseUri("http://api.open-notify.org/astros.json").build();
    }
}
