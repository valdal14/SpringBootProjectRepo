package com.vd14.persistence.repositories;

import com.vd14.persistence.models.UniClass;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class UniversityJPARepositoryTest {

    @Autowired
    private UniversityJPARepository repository;

    @Test
    void insert() {
        UniClass uniClass = new UniClass(0, "MIT", 98, "London", "United Kingdom");
        repository.insert(uniClass);
    }

    @Test
    void update() {
        UniClass uniClass = new UniClass(1L, "MIT", 99, "Cambridge", "USA");
        repository.update(uniClass);
        Optional<UniClass> optional = repository.findById(uniClass.getId());
        // Assert first that the optional is not null and then assert all
        assertTrue(optional.isPresent());

        assertAll(
                () -> assertEquals(uniClass.getId(), optional.orElse(null).getId()),
                () -> assertEquals(uniClass.getName(), optional.orElse(null).getName()),
                () -> assertEquals(uniClass.getOverallScore(), optional.orElse(null).getOverallScore()),
                () -> assertEquals(uniClass.getCity(), optional.orElse(null).getCity()),
                () -> assertEquals(uniClass.getCountry(), optional.orElse(null).getCountry())
        );
    }

    @Test
    void findById() {
        Optional<UniClass> uniClass = repository.findById(1L);
        assertTrue(uniClass.isPresent());
    }

    @Test
    void findAll() {
        List<UniClass> uniClasses = repository.findAll();
        assertEquals(10, uniClasses.size());
    }
}