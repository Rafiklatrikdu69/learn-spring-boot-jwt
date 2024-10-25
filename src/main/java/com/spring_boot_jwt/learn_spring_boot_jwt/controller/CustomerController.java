package com.spring_boot_jwt.learn_spring_boot_jwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @GetMapping
    public String getCustomer() {
        return "Customer";
    }
}
