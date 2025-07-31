package com.example.producto;

import com.example.application.dto.CreateProductRequest;
import com.example.application.service.ProductServiceImpl;
import com.example.domain.model.Product;
import com.example.domain.repository.ProductRepository;
import org.junit.jupiter.api.Test;
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

@org.junit.jupiter.api.extension.ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    void shouldCreateProduct() {
        CreateProductRequest request = new CreateProductRequest();
        request.setNombre("Laptop");
        request.setPrecio(BigDecimal.valueOf(999));
        request.setDescripcion("Portátil de gama media");

        Product expectedProduct = new Product(null, "Laptop", BigDecimal.valueOf(999), "Portátil de gama media");
        Product savedProduct = new Product(1L, "Laptop", BigDecimal.valueOf(999), "Portátil de gama media");

        when(productRepository.save(any(Product.class))).thenReturn(savedProduct);

        Product result = productService.create(request);

        assertEquals(1L, result.getId());
        assertEquals("Laptop", result.getName());
        verify(productRepository).save(any(Product.class));
    }

    @Test
    void shouldFindProductById() {
        Long productId = 1L;
        Product product = new Product(1L, "Laptop", BigDecimal.valueOf(999), "Portátil");

        when(productRepository.findById(productId)).thenReturn(Optional.of(product));

        Optional<Product> result = productService.findById(productId);

        assertTrue(result.isPresent());
        assertEquals(productId, result.get().getId());
        assertEquals("Laptop", result.get().getName());
        verify(productRepository).findById(productId);
    }

    @Test
    void shouldReturnEmptyOptionalWhenProductNotFound() {
        Long productId = 999L;

        when(productRepository.findById(productId)).thenReturn(Optional.empty());

        Optional<Product> result = productService.findById(productId);

        assertFalse(result.isPresent());
        verify(productRepository).findById(productId);
    }

    @Test
    void shouldListAllProducts() {
        List<Product> products = List.of(
                new Product(1L, "Laptop", BigDecimal.valueOf(999), "Gama media"),
                new Product(2L, "Mouse", BigDecimal.valueOf(25), "Ergonómico")
        );

        when(productRepository.findAll()).thenReturn(products);

        List<Product> result = productService.findAll();

        assertEquals(2, result.size());
        verify(productRepository).findAll();
    }



}
