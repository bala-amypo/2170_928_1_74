package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Claim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String description;
    private Double claimAmount; // Matches getClaimAmount()
    private LocalDate claimDate; // Matches getClaimDate()
    private String status;       // Matches getStatus()

    @ManyToOne
    private Policy policy;       // Matches getPolicy()

    @ManyToMany
    @JoinTable(
        name = "claim_fraud_rules",
        joinColumns = @JoinColumn(name = "claim_id"),
        inverseJoinColumns = @JoinColumn(name = "fraud_rule_id")
    )
    private Set<FraudRule> suspectedRules = new HashSet<>();

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Double getClaimAmount() { return claimAmount; }
    public void setClaimAmount(Double claimAmount) { this.claimAmount = claimAmount; }
    public LocalDate getClaimDate() { return claimDate; }
    public void setClaimDate(LocalDate claimDate) { this.claimDate = claimDate; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Policy getPolicy() { return policy; }
    public void setPolicy(Policy policy) { this.policy = policy; }
    public Set<FraudRule> getSuspectedRules() { return suspectedRules; }
    public void setSuspectedRules(Set<FraudRule> suspectedRules) { this.suspectedRules = suspectedRules; }
}