package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long policyId;
    private Double amount;

    public Long getId() {
        return id;
    }

    public Long getPolicyId() {
        return policyId;
    }

    public Double getAmount() {
        return amount;
    }
}
