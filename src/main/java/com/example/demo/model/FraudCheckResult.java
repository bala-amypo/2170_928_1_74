package com.example.demo.model;

import java.time.LocalDateTime;

public class FraudCheckResult {
    private boolean isFraudulent;
    private String matchedRules;
    private String triggeredRuleName;
    private String rejectionReason;
    private LocalDateTime checkedAt;
    private Claim claim;

    // Getters and Setters
    public boolean isIsFraudulent() { return isFraudulent; }
    public void setIsFraudulent(boolean fraudulent) { isFraudulent = fraudulent; }
    public String getMatchedRules() { return matchedRules; }
    public void setMatchedRules(String matchedRules) { this.matchedRules = matchedRules; }
    public String getTriggeredRuleName() { return triggeredRuleName; }
    public void setTriggeredRuleName(String triggeredRuleName) { this.triggeredRuleName = triggeredRuleName; }
    public String getRejectionReason() { return rejectionReason; }
    public void setRejectionReason(String rejectionReason) { this.rejectionReason = rejectionReason; }
    public LocalDateTime getCheckedAt() { return checkedAt; }
    public void setCheckedAt(LocalDateTime checkedAt) { this.checkedAt = checkedAt; }
    public Claim getClaim() { return claim; }
    public void setClaim(Claim claim) { this.claim = claim; }
}