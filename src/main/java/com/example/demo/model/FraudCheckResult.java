package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class FraudCheckResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Claim claim;

    private boolean fraudDetected;
    private String ruleName;
    private String severity;
    private LocalDateTime checkedAt;

    public FraudCheckResult() {
    }

    public FraudCheckResult(
            Claim claim,
            boolean fraudDetected,
            String ruleName,
            String severity,
            LocalDateTime checkedAt) {

        this.claim = claim;
        this.fraudDetected = fraudDetected;
        this.ruleName = ruleName;
        this.severity = severity;
        this.checkedAt = checkedAt;
    }

    public Long getId() {
        return id;
    }

    public Claim getClaim() {
        return claim;
    }

    public boolean isFraudDetected() {
        return fraudDetected;
    }
}
