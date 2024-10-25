package com.spring_boot_jwt.learn_spring_boot_jwt.service;

import com.spring_boot_jwt.learn_spring_boot_jwt.entity.Product;
import com.spring_boot_jwt.learn_spring_boot_jwt.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    public List<Product> getAllProducts(){
        return  this.productRepository.findAll();
    }
}
