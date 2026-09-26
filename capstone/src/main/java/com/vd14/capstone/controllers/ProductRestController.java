package com.vd14.capstone.controllers;

import com.vd14.capstone.entities.Product;
import com.vd14.capstone.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("product")
public class ProductRestController {
    @Autowired
    private final ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public Optional<Product> getProduct(@PathVariable Long id) {
        return productService.findById(id);
    }

    @GetMapping(path = "/all", produces = "application/json")
    public List<Product> getAll() {
        return productService.findAll();
    }
}
