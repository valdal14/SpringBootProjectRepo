package com.vd14.capstone.services;

import com.vd14.capstone.entities.Product;
import com.vd14.capstone.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

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
    void findByIdSuccessfullyReturnProduct() {
        // ARRANGE
        Product expectedProduct = makeProduct(1L, "MacBook Pro 16", BigDecimal.valueOf(2499.0), true);
        when(productRepository.findById(expectedProduct.getId())).thenReturn(Optional.of(expectedProduct));
        // ACT
        Optional<Product> optionalProduct = productService.findById(expectedProduct.getId());
        // ASSERT
        optionalProduct.ifPresent(actualProduct -> assertEquals(expectedProduct, actualProduct));
        // VERIFY
        verify(productRepository).findById(expectedProduct.getId());
    }

    @Test
    void findByIdNotFoundReturnFalse() {
        // ARRANGE
        when(productRepository.findById(1L)).thenReturn(Optional.empty());
        // ACT
        Optional<Product> optionalProduct = productService.findById(1L);
        // ASSERT
        assertFalse(optionalProduct.isPresent());
        // VERIFY
        verify(productRepository).findById(1L);
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

    @Test
    void findAllSuccessfullyFindAllProducts() {
        // ARRANGE
        Product p1 = makeProduct(1L, "iPhone 18 PRO", BigDecimal.valueOf(1299.0), true);
        Product p2 = makeProduct(2L, "MacBook Pro 16", BigDecimal.valueOf(2499.0), true);
        List<Product> productsToAdd = List.of(p1, p2);
        List<Product> productsAdded = List.of(p1, p2);
        when(productRepository.findAll()).thenReturn(productsAdded);
        // ACT
        List<Product> productList = productService.findAll();
        // ASSERT
        // Let's first assert that the productList is not empty
        assertFalse(productList.isEmpty());
        assertEquals(productsToAdd.size(), productList.size());
        // VERIFY
        verify(productRepository).findAll();
    }

    @Test
    void updateSuccessfullyUpdateProduct() {
        // ARRANGE
        Product stored = makeProduct(1L, "iPhone 18 PRO", BigDecimal.valueOf(1299.0), true);
        Product update = makeProduct(1L, "iPhone 18 PRO", BigDecimal.valueOf(1199.0), true);
        when(productRepository.save(any(Product.class))).thenReturn(update);
        // ACT
        Product updatedProduct = productService.update(stored);
        // ASSERT
        assertEquals(update, updatedProduct);
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