package com.example.demo.security;

import com.example.demo.model.User;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {
    public JwtUtil() {}
    public JwtUtil(String secret, int exp) {}

    public String generateToken(User user) { return "mock-token"; }
    public String generateToken(Long id, String email, String role) { return "mock-token"; }
    public boolean validateToken(String token) { return true; }
    public String getEmailFromToken(String token) { return "user@example.com"; }
    public String getRoleFromToken(String token) { return "ROLE_USER"; }
}