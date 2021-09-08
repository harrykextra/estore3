package com.harrymanproject.estore3.service.product;

import com.harrymanproject.estore3.data.exception.ProductException;
import com.harrymanproject.estore3.data.model.Product;

import java.util.List;

public interface ProductService {
    void saveProduct(Product product) throws ProductException;
    void updateProduct(Product product) throws ProductException;
    Product findProductById(Integer id);
    List<Product> findAllProducts();
    void deleteProductById(Integer id);
}

