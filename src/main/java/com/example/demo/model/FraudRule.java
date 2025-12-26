package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class FraudRule {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ruleName;
    private String conditionField;
    private String operator;
    private String value;
    private String description;

    public FraudRule() {}

    // Add this constructor for the tests
    public FraudRule(String ruleName, String conditionField, String operator, String value, String description) {
        this.ruleName = ruleName;
        this.conditionField = conditionField;
        this.operator = operator;
        this.value = value;
        this.description = description;
    }

    // ... Keep Getters/Setters ...
}