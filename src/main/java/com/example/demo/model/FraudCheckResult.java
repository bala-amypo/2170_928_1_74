package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class FraudCheckResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long claimId;
    private boolean fraudDetected;

    public Long getId() {
        return id;
    }

    public Long getClaimId() {
        return claimId;
    }

    public boolean isFraudDetected() {
        return fraudDetected;
    }
}
