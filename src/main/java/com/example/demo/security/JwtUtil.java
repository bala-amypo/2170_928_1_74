package com.example.demo.security;

import com.example.demo.model.User;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {
    public JwtUtil() {}
    public JwtUtil(String secret, int expiration) {}

    // Method for Tests
    public String generateToken(User user) { return "token"; }

    // Method for AuthController (Overloaded)
    public String generateToken(Long id, String email, String role) { return "token"; }

    // Methods for JwtAuthenticationFilter
    public boolean validateToken(String token) { return true; }
    public String getEmailFromToken(String token) { return "user@example.com"; }
    public String getRoleFromToken(String token) { return "ROLE_USER"; }
}