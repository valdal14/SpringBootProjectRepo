package com.vd14.persistence.repositories;

import com.vd14.persistence.models.University;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UniversityRepositoryTest {
    @Autowired
    private UniversityRepository repository;

    @Test
    void insert() {
    }

    @Test
    void update() {
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
        List<University> entities = repository.findAll();
        int expectedCount = 10;
        assertEquals(expectedCount, entities.size());
    }
}