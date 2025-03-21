package com.example.User_management.Controller;

import com.example.User_management.Entity.Product;
import com.example.User_management.Service.ProductService.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product/api/")
public class ProductController {
    @Autowired
    private ProductServiceImpl productService;
    @PostMapping("create-product")
    public ResponseEntity<String> createPrudctInDb(@RequestBody Product product){
        String response = productService.createProduct(product);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
