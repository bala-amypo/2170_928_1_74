package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Claim {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate claimDate;
    private Double claimAmount;
    private String description;
    @ManyToOne @JoinColumn(name = "policy_id")
    private Policy policy;

    public Claim() {}

    // Add this constructor for the tests
    public Claim(Policy policy, LocalDate claimDate, Double claimAmount, String description) {
        this.policy = policy;
        this.claimDate = claimDate;
        this.claimAmount = claimAmount;
        this.description = description;
    }

    // ... Keep all existing Getters/Setters ...
}