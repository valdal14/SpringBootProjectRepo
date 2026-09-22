package com.vd14.restclients.services;


import com.vd14.restclients.models.AstroModelRecord;
import org.springframework.web.service.annotation.GetExchange;

public interface AstroInterface {
    @GetExchange("/astros.json")
    AstroModelRecord getAstroExchange();
}
