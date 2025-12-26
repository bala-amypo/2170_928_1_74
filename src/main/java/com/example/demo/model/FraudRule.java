package com.example.demo.model;

import jakarta.persistence.*;
import java.util.Set;
import java.util.HashSet;

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

    // ADD THIS: The tests are calling setClaims and getClaims
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

    // Existing Getters/Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getRuleName() { return ruleName; }
    public void setRuleName(String ruleName) { this.ruleName = ruleName; }
    public String getConditionField() { return conditionField; }
    public void setConditionField(String conditionField) { this.conditionField = conditionField; }
    public String getOperator() { return operator; }
    public void setOperator(String operator) { this.operator = operator; }
    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }
    public String getSeverity() { return severity; }
    public void setSeverity(String severity) { this.severity = severity; }

    // ADD THESE: Required for the Test cases
    public Set<Claim> getClaims() { return claims; }
    public void setClaims(Set<Claim> claims) { this.claims = claims; }
}