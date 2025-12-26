package com.example.demo.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class FraudRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleName;
    private String conditionField; // Matches getConditionField()
    private String operator;       // Matches getOperator()
    private String value;          // Matches getValue()
    private String severity;       // Matches getSeverity()

    @ManyToMany(mappedBy = "suspectedRules")
    private Set<Claim> claims = new HashSet<>();

    // Getters and Setters
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
    public Set<Claim> getClaims() { return claims; }
    public void setClaims(Set<Claim> claims) { this.claims = claims; }
}