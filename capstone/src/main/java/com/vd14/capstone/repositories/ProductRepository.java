package com.vd14.capstone.repositories;

import com.vd14.capstone.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> { }
