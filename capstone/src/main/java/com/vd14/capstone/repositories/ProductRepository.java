package com.vd14.capstone.repositories;

import com.vd14.capstone.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllBy(String name);
}
