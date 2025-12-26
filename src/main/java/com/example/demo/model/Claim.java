package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Claim {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate claimDate;
    private Double claimAmount;
    private String description;
    private String status;

    @ManyToOne @JoinColumn(name = "policy_id")
    private Policy policy;

    @ManyToMany
    @JoinTable(
        name = "claim_fraud_rules",
        joinColumns = @JoinColumn(name = "claim_id"),
        inverseJoinColumns = @JoinColumn(name = "fraud_rule_id")
    )
    private Set<FraudRule> suspectedRules = new HashSet<>();

    public Claim() {}
    public Claim(Policy policy, LocalDate claimDate, Double claimAmount, String description) {
        this.policy = policy;
        this.claimDate = claimDate;
        this.claimAmount = claimAmount;
        this.description = description;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Set<FraudRule> getSuspectedRules() { return suspectedRules; }
    public void setSuspectedRules(Set<FraudRule> suspectedRules) { this.suspectedRules = suspectedRules; }
    // Getters/Setters for date, amount, description, policy...
}