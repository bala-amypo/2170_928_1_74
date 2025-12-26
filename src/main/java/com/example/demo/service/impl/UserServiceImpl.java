package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.example.demo.service.UserService;
import com.example.demo.repository.UserRepository;
import com.example.demo.model.User;
import com.example.demo.exception.ResourceNotFoundException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repo;
    private final PasswordEncoder encoder;

    public UserServiceImpl(UserRepository repo, PasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

    @Override
    public User registerUser(User user) {
        if (repo.existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("Duplicate email");
        }
        if (user.getRole() == null) {
            user.setRole("USER");
        }
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return repo.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Override
    public User findById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }
}
