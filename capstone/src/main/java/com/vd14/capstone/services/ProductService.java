package com.vd14.capstone.services;

import com.vd14.capstone.entities.Product;
import com.vd14.capstone.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public boolean existsById(Long id) {
        return productRepository.existsById(id);
    }

    public Product getReferenceById(Long id) {
        return productRepository.getReferenceById(id);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }
}
