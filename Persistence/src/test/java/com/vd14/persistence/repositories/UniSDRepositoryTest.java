package com.vd14.persistence.repositories;

import com.vd14.persistence.models.UniClass;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UniSDRepositoryTest {
    @Autowired
    private UniSDRepository uniSDRepository;

    @Test
    void findByUniversityName() {
        String name = "University of Oxford";
        List<UniClass> uni = uniSDRepository.findByName(name);
        assertAll(
                ()-> assertEquals(1, uni.size()),
                ()-> assertEquals(name, Objects.requireNonNull(uni.stream().findFirst().orElse(null)).getName())
        );
    }
}