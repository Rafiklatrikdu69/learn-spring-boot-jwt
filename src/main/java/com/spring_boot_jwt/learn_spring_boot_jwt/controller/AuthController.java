package com.spring_boot_jwt.learn_spring_boot_jwt.controller;

import com.spring_boot_jwt.learn_spring_boot_jwt.request.AuthenticationRequest;
import com.spring_boot_jwt.learn_spring_boot_jwt.response.AuthenticationResponse;
import com.spring_boot_jwt.learn_spring_boot_jwt.utility.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping
public class AuthController {
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private UserDetailsService userDetailsService;
    @PostMapping("/authenticate")
    public AuthenticationResponse createToken(@RequestBody
                                              AuthenticationRequest request) {
        log.info("createToken(-)");
        // Authenticate the user
        userDetailsService.loadUserByUsername(request.getUsername());
        // Generate the token
        String jwtToken = jwtUtil.generateToken(request.getUsername());
        return new AuthenticationResponse(jwtToken);
    }
}
