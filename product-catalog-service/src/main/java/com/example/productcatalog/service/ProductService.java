package com.example.productcatalog.service;

import com.example.productcatalog.entity.Product;
import com.example.productcatalog.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

   
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    
    public Product updateProduct(Long id, Product updatedProduct) {
        Product existingProduct = productRepository.findById(id).orElse(null);
        if (existingProduct != null) {
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setDescription(updatedProduct.getDescription());
            existingProduct.setPrice(updatedProduct.getPrice());
            existingProduct.setStockQuantity(updatedProduct.getStockQuantity());
            return productRepository.save(existingProduct);
        }
        return null;
    }

    
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    
    public List<Product> searchProducts(String keyword) {
        return productRepository.findByNameContainingIgnoreCase(keyword);
    }
}