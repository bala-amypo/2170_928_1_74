package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Policy {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String policyNumber;
    private String policyType;
    private LocalDate startDate;
    private LocalDate endDate;
    @ManyToOne @JoinColumn(name = "user_id")
    private User user;

    public Policy() {} // Keep default

    // Add this constructor for the tests
    public Policy(User user, String policyNumber, String policyType, LocalDate startDate, LocalDate endDate) {
        this.user = user;
        this.policyNumber = policyNumber;
        this.policyType = policyType;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // ... Keep all existing Getters/Setters ...
}