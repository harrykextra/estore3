package com.harrymanproject.estore3.service.product;

import com.harrymanproject.estore3.data.exception.ProductException;
import com.harrymanproject.estore3.data.model.Product;
import com.harrymanproject.estore3.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepository productRepository;

    @Override
    public void saveProduct(Product product) throws ProductException {
        productRepository.saveProduct(product);
    }

    @Override
    public void updateProduct(Product product) throws ProductException {
        if (product.getId() == null){
            throw new ProductException("Id cannot be null");
        }
        Product product1 = productRepository.findById(product.getId()).orElse(null);
        if (product1 == null){
            throw new ProductException("This product is not in our database");
        }
        if (product.getName() != null){
            product1.setName(product.getName());
        }
        if (product.getDescription() != null){
            product1.setDescription(product.getDescription());
        }
        if (product.getQuantity() != null){
            product1.setQuantity(product.getQuantity());
        }
        if (product.getPrice() != null){
            product1.setPrice(product.getPrice());
        }
        if (product.getExpDate() != null){
            product1.setExpDate(product.getExpDate());
        }
        productRepository.save(product1);
    }

    @Override
    public Product findProductById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void deleteProductById(Integer id) {
        productRepository.deleteById(id);
    }
}
