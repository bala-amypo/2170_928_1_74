package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class FraudRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleName;
    private String conditionField;
    private String value;
    private String severity;

    public FraudRule() {
    }

    public Long getId() {
        return id;
    }

    public String getRuleName() {
        return ruleName;
    }

    public String getConditionField() {
        return conditionField;
    }

    public String getValue() {
        return value;
    }

    public String getSeverity() {
        return severity;
    }
}
