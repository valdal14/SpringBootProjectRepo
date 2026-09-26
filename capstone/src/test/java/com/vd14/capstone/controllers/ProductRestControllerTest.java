package com.vd14.capstone.controllers;

import com.vd14.capstone.entities.Product;
import com.vd14.capstone.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductRestController.class)
class ProductRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ProductService productService;

    @Test
    void getProductById() throws Exception {
        // ARRANGE
        Optional<Product> product = Optional.of(new Product(1L, "Pixel Watch 5", BigDecimal.valueOf(499.00)));
        when(productService.findById(1L)).thenReturn(product);
        // ACT
        mockMvc.perform(get("/product/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Pixel Watch 5"))
                .andExpect(jsonPath("$.price").value(499.00));
        // VERIFY
        verify(productService).findById(1L);
    }

    @Test
    void getProductByIdNotFound() throws Exception {
        // ARRANGE
        when(productService.findById(4L)).thenReturn(Optional.empty());
        // ACT
        mockMvc.perform(get("/product/4"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().string("null"));
        // VERIFY
        verify(productService).findById(4L);
    }
}