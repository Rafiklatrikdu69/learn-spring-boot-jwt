package com.spring_boot_jwt.learn_spring_boot_jwt.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AuthenticationResponse {
    private String jwttoken;
}
