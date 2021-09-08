package com.harrymanproject.estore3.service.product;

import com.harrymanproject.estore3.data.exception.ProductException;
import com.harrymanproject.estore3.data.model.Product;
import com.harrymanproject.estore3.data.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceImplTest {

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductService productService = new ProductServiceImpl();
    Product product;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        product = new Product();
    }

    @Test
    void saveProductTest() throws ProductException{
        productService.saveProduct(product);
        verify(productRepository, times(1)).saveProduct(product);
    }

    @Test
    void updateProductTest() throws ProductException{
        product.setId(1);
        product.setName("Onion");
        when(productRepository.findById(1)).thenReturn(Optional.of(product));
        productService.updateProduct(product);
        verify(productRepository, times(2));
    }

    @Test
    void findProductByIdTest(){
        when(productRepository.findById(1)).thenReturn(Optional.of(product));
        productService.findProductById(1);
        verify(productRepository, times(1)).findById(1);
    }

    @Test
    void findAllProductsTest(){
        when(productRepository.findAll()).thenReturn(List.of(product));
        productService.findAllProducts();
        verify(productRepository, times(1)).findAll();
    }

    @Test
    void deleteProductByIdTest(){
        productService.deleteProductById(1);
        verify(productRepository, times(1)).deleteById(1);
    }
}