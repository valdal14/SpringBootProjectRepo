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
        University expectedUni = makeUniversity(1L,
                "Massachusetts Institute of Technology (MIT)",
                100.00,
                "Cambridge",
                "United States"
        );

        University actual = this.repository.findById(1L);
        assertAll(
                () -> assertEquals(expectedUni.getId(), actual.getId()),
                () -> assertEquals(expectedUni.getName(), actual.getName()),
                () -> assertEquals(expectedUni.getOverallScore(), actual.getOverallScore()),
                () -> assertEquals(expectedUni.getCity(), actual.getCity()),
                () -> assertEquals(expectedUni.getCountry(), actual.getCountry())
        );
    }

    @Test
    void findAll() {
        List<University> entities = repository.findAll();
        int expectedCount = 10;
        assertEquals(expectedCount, entities.size());
    }

    private University makeUniversity(Long id, String name, Double overallScore, String city, String country) {
        return new University(id, name, overallScore, city, country);
    }
}