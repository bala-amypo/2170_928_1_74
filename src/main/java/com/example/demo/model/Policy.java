package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Policy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String policyType;

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public String getPolicyType() {
        return policyType;
    }
}
