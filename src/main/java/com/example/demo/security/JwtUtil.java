package com.example.demo.security;

import com.example.demo.model.User;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {
    private String secret;
    private int expiration;

    public JwtUtil() {}

    // Add constructor for the test: new JwtUtil("secret", 3600)
    public JwtUtil(String secret, int expiration) {
        this.secret = secret;
        this.expiration = expiration;
    }

    // Add method for the test: generateToken(user)
    public String generateToken(User user) {
        // Your token generation logic
        return "sample-token-for-" + user.getEmail();
    }
    
    // Keep your other generateToken(Long id, String email, String role) if it exists
}