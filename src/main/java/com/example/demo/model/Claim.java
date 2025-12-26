package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Claim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate claimDate;
    private Double claimAmount;
    private String description;

    @ManyToOne
    @JoinColumn(name = "policy_id")
    private Policy policy;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDate getClaimDate() { return claimDate; }
    public void setClaimDate(LocalDate claimDate) { this.claimDate = claimDate; }
    public Double getClaimAmount() { return claimAmount; }
    public void setClaimAmount(Double claimAmount) { this.claimAmount = claimAmount; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Policy getPolicy() { return policy; }
    public void setPolicy(Policy policy) { this.policy = policy; }
}package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Set;
import java.util.HashSet;

@Entity
public class Claim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate claimDate;
    private Double claimAmount;
    private String description;
    private String status; // Missing field 1

    @ManyToMany
    private Set<FraudRule> suspectedRules = new HashSet<>(); // Missing field 2

    @ManyToOne
    @JoinColumn(name = "policy_id")
    private Policy policy;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDate getClaimDate() { return claimDate; }
    public void setClaimDate(LocalDate claimDate) { this.claimDate = claimDate; }
    public Double getClaimAmount() { return claimAmount; }
    public void setClaimAmount(Double claimAmount) { this.claimAmount = claimAmount; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Set<FraudRule> getSuspectedRules() { return suspectedRules; }
    public void setSuspectedRules(Set<FraudRule> suspectedRules) { this.suspectedRules = suspectedRules; }
    public Policy getPolicy() { return policy; }
    public void setPolicy(Policy policy) { this.policy = policy; }
}