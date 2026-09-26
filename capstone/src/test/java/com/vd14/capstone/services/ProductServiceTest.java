package com.vd14.capstone.services;

import com.vd14.capstone.entities.Product;
import com.vd14.capstone.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {
    // @Mock creates a pure dummy object, no Spring Context required
    @Mock
    private ProductRepository productRepository;

    // @InjectMocks automatically instantiates ProductService and injects the @Mock above into its constructor
    @InjectMocks
    private ProductService productService;

    @Test
    void existsByIdReturnTrue() {
        // ARRANGE
        when(productRepository.existsById(1L)).thenReturn(Boolean.TRUE);
        // ACT
        boolean wasFoundIt = productService.existsById(1L);
        // ASSERT
        assertTrue(wasFoundIt);
        // VERIFY
        verify(productRepository).existsById(1L);
    }

    @Test
    void getReferenceByIdSuccessfullyReturnProduct() {
        // ARRANGE
        Product expectedProduct = makeProduct(1L, "MacBook Pro 16", BigDecimal.valueOf(2499.0), true);
        when(productRepository.getReferenceById(1L)).thenReturn(expectedProduct);
        // ACT
        Product actualProduct = productService.getReferenceById(1L);
        // ASSERT
        assertEquals(expectedProduct, actualProduct);
        // VERIFY
        verify(productRepository).getReferenceById(1L);
    }

    @Test
    void saveSuccessfullySaveProduct() {
        // ARRANGE
        Product newProduct = makeProduct(0L, "iPhone 18 PRO", BigDecimal.valueOf(1299.0), false);
        Product savedProduct = makeProduct(4L, "iPhone 18 PRO", BigDecimal.valueOf(1299.0), true);
        // Using any() because the service might create a new instance or alter it before saving
        when(productRepository.save(any(Product.class))).thenReturn(savedProduct);
        // ACT
        Product productAdded = productService.save(newProduct);
        // ASSERT
        assertAll(
                () -> assertTrue(savedProduct.getId() > 0L),
                () -> assertEquals(newProduct.getName(), productAdded.getName()),
                () -> assertEquals(newProduct.getPrice(), productAdded.getPrice())
        );
        // VERIFY
        verify(productRepository).save(any(Product.class));
    }

    /**
     * Helpers Method used to create a new Product
     * @param id The id of the product
     * @param name The name of the product
     * @param price the price of the product
     * @param productWithID bool flag used to inform which construct to use
     * @return Product
     */
    private Product makeProduct(Long id, String name, BigDecimal price, Boolean productWithID) {
        return productWithID ? new  Product(id, name, price) : new Product(name, price);
    }
}