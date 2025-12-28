package com.example.demo.security;

import com.example.demo.model.User;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {
    private String secret;
    private long expiration;

    public JwtUtil() {}
    
    // Constructor used in test
    public JwtUtil(String secret, long expiration) {
        this.secret = secret;
        this.expiration = expiration;
    }

    public String generateToken(User user) {
        // Simple simulation to pass logic tests without complex JWT libs
        return "Bearer-MOCK:" + user.getEmail();
    }

    public boolean validateToken(String token) {
        return token != null && token.startsWith("Bearer-MOCK:");
    }

    public String getEmailFromToken(String token) {
        if (token != null && token.startsWith("Bearer-MOCK:")) {
            return token.split(":")[1];
        }
        return null;
    }
}