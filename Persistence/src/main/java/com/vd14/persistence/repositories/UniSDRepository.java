package com.vd14.persistence.repositories;

import com.vd14.persistence.models.UniClass;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UniSDRepository extends JpaRepository<UniClass, Long> {
    List<UniClass> findByName(String name);
}
