package com.spring_boot_jwt.learn_spring_boot_jwt;

import com.spring_boot_jwt.learn_spring_boot_jwt.entity.Product;
import com.spring_boot_jwt.learn_spring_boot_jwt.entity.Users;
import com.spring_boot_jwt.learn_spring_boot_jwt.repo.ProductRepository;
import com.spring_boot_jwt.learn_spring_boot_jwt.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;
    @Override
    public void run(String... args) throws Exception {
        Users user = new Users();
        user.setUsername("toto");
        user.setPassword("titi");
        user.setEnabled(true);
        userRepository.save(user);
        Product product = new Product();
        product.setName("produit 1");
        product.setPrice(12.00);
        productRepository.save(product);
    }

}
