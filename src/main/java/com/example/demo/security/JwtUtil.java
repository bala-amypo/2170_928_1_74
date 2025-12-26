package com.example.demo.security;

import com.example.demo.model.User;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {
    private String secret;
    private int expiration;

    public JwtUtil() {}

    public JwtUtil(String secret, int expiration) {
        this.secret = secret;
        this.expiration = expiration;
    }

    public String generateToken(User user) {
        return "mock-token-for-" + user.getEmail();
    }
}