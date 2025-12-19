package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class FraudRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleName;
    private String severity;

    public Long getId() {
        return id;
    }

    public String getRuleName() {
        return ruleName;
    }

    public String getSeverity() {
        return severity;
    }
}
