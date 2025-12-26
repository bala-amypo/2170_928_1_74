package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Policy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String policyNumber;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getPolicyNumber() { return policyNumber; }
    public void setPolicyNumber(String policyNumber) { this.policyNumber = policyNumber; }
}