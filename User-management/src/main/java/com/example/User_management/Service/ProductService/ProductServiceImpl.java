package com.example.User_management.Service.ProductService;

import com.example.User_management.Entity.Product;
import com.example.User_management.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductInterface{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public String createProduct(Product product) {
        productRepository.save(product);
        return "product created successfully!";
    }
}
