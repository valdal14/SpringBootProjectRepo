package com.vd14.restclients.services;

import com.vd14.restclients.models.AstroModelRecord;
import com.vd14.restclients.repository.AstroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AstroService {
    private final AstroRepository astroRepository;

    @Autowired
    public AstroService(AstroRepository astroRepository) {
        this.astroRepository = astroRepository;
    }

    public AstroModelRecord getRecords() {
        return this.astroRepository.getRecord();
    }
}
