package com.vd14.persistence.services;

import com.vd14.persistence.models.UniClass;
import com.vd14.persistence.repositories.UniSDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniSDService {
    @Autowired
    private final UniSDRepository uniSDRepository;

    public UniSDService(UniSDRepository uniSDRepository) {
        this.uniSDRepository = uniSDRepository;
    }

    public List<UniClass> findAll() {
        return uniSDRepository.findAll();
    }
}
