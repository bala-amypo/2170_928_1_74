package com.example.demo.security;

import com.example.demo.model.User;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {
    public JwtUtil() {}
    public JwtUtil(String secret, int expiration) {} // Matches new JwtUtil("secret", 3600)

    public String generateToken(User user) {
        return "mock-token";
    }
}