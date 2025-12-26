package com.example.demo.dto;

import java.time.LocalDate;

public class ClaimDto {
    private Long id;
    private Long policyId;
    private LocalDate claimDate;
    private Double claimAmount;
    private String description;
    private String status;

    // Standard Setters
    public void setId(Long id) { this.id = id; }
    public void setPolicyId(Long policyId) { this.policyId = policyId; }
    public void setClaimDate(LocalDate claimDate) { this.claimDate = claimDate; }
    public void setClaimAmount(Double claimAmount) { this.claimAmount = claimAmount; }
    public void setDescription(String description) { this.description = description; }
    public void setStatus(String status) { this.status = status; }

    // Standard Getters
    public Long getId() { return id; }
    public Long getPolicyId() { return policyId; }
    public LocalDate getClaimDate() { return claimDate; }
    public Double getClaimAmount() { return claimAmount; }
    public String getDescription() { return description; }
    public String getStatus() { return status; }
}