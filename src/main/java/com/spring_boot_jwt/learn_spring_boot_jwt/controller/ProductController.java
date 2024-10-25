package com.spring_boot_jwt.learn_spring_boot_jwt.controller;

import com.spring_boot_jwt.learn_spring_boot_jwt.entity.Product;
import com.spring_boot_jwt.learn_spring_boot_jwt.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping
    public ResponseEntity<List<Product>> getProduct(){
        List<Product> productList = this.productService.getAllProducts();
       return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
    }
}
