package com.example.demo.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "fraud_rule")
public class FraudRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleName;

    private String description;

    private Double threshold;

    // 🔴 REQUIRED FOR TEST CASES
    @ManyToMany
    @JoinTable(
        name = "fraudrule_claims",
        joinColumns = @JoinColumn(name = "fraudrule_id"),
        inverseJoinColumns = @JoinColumn(name = "claim_id")
    )
    private Set<Claim> claims = new HashSet<>();

    // ===== Getters and Setters =====

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getThreshold() {
        return threshold;
    }

    public void setThreshold(Double threshold) {
        this.threshold = threshold;
    }

    // 🔴 THESE TWO METHODS FIX YOUR ERROR
    public Set<Claim> getClaims() {
        return claims;
    }

    public void setClaims(Set<Claim> claims) {
        this.claims = claims;
    }
}
