package com.example.demo.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class FraudRule {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ruleName;
    private String conditionField;
    private String operator;
    private String value;
    private String description;
    private String severity;

    @ManyToMany(mappedBy = "suspectedRules")
    private Set<Claim> claims = new HashSet<>();

    public FraudRule() {}
    public FraudRule(String ruleName, String conditionField, String operator, String value, String description) {
        this.ruleName = ruleName;
        this.conditionField = conditionField;
        this.operator = operator;
        this.value = value;
        this.description = description;
    }

    public String getConditionField() { return conditionField; }
    public String getOperator() { return operator; }
    public String getValue() { return value; }
    public String getSeverity() { return severity; }
    public Set<Claim> getClaims() { return claims; }
    public void setClaims(Set<Claim> claims) { this.claims = claims; }
    // Other Getters/Setters...
}