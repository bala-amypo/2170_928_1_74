package com.example.demo.service;

import com.example.demo.model.User;

public interface UserService {
    User register(User user); // Ensure this is present
    User findByEmail(String email);
    // ... other methods
}