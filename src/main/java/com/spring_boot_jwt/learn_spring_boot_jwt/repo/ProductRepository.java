package com.spring_boot_jwt.learn_spring_boot_jwt.repo;

import com.spring_boot_jwt.learn_spring_boot_jwt.entity.Product;
import com.spring_boot_jwt.learn_spring_boot_jwt.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Optional<Product> findByName(String name);

}
