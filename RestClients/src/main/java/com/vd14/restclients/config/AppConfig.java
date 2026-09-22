package com.vd14.restclients.config;

import com.vd14.restclients.services.AstroInterface;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.restclient.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

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

    @Bean
    public AstroInterface astroHttpServiceClient(@Value("${astro.base.url}") String baseUrl) {
        WebClient webClient = WebClient.create(baseUrl);
        WebClientAdapter adapter = WebClientAdapter.create(webClient);
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();
        return factory.createClient(AstroInterface.class);
    }
}
