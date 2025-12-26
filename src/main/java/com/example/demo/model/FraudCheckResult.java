package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "fraud_check_results")
public class FraudCheckResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "claim_id")
    private Claim claim;

    private Boolean isFraudulent;
    private String triggeredRuleName;
    private String rejectionReason;
    private LocalDateTime checkedAt;

    public FraudCheckResult() {}

    // Add these specific setters
    public void setClaim(Claim claim) { this.claim = claim; }
    public void setIsFraudulent(Boolean isFraudulent) { this.isFraudulent = isFraudulent; }
    public void setTriggeredRuleName(String triggeredRuleName) { this.triggeredRuleName = triggeredRuleName; }
    public void setRejectionReason(String rejectionReason) { this.rejectionReason = rejectionReason; }
    public void setCheckedAt(LocalDateTime checkedAt) { this.checkedAt = checkedAt; }
    
    // Getters for completeness
    public Long getId() { return id; }
    public Claim getClaim() { return claim; }
    public Boolean getIsFraudulent() { return isFraudulent; }
    public String getTriggeredRuleName() { return triggeredRuleName; }
    public String getRejectionReason() { return rejectionReason; }
    public LocalDateTime getCheckedAt() { return checkedAt; }
}