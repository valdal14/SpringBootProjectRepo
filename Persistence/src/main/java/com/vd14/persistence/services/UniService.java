package com.vd14.persistence.services;

import com.vd14.persistence.models.University;
import com.vd14.persistence.repositories.UniRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniService {
    private final UniRepository uniRepository;

    @Autowired
    public UniService(UniRepository uniRepository) {
        this.uniRepository = uniRepository;
    }

    public List<University> findAll() {
        return uniRepository.findAll();
    }
}
