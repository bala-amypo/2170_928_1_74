package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class FraudCheckResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String matchedRules;

    public String getMatchedRules() { return matchedRules; }
    public void setMatchedRules(String matchedRules) { this.matchedRules = matchedRules; }
}