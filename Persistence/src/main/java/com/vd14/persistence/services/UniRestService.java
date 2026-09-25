package com.vd14.persistence.services;

import com.vd14.persistence.models.UniClass;
import com.vd14.persistence.repositories.UniJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniRestService {
    @Autowired
    private final UniJPARepository uniRepository;

    public UniRestService(UniJPARepository uniRepository) {
        this.uniRepository = uniRepository;
    }

    public List<UniClass> findAll() {
        return uniRepository.findAll();
    }
}
