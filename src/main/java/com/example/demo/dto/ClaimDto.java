package com.example.demo.dto;

import java.time.LocalDate;

public class ClaimDto {
    public Long id;
    public Long policyId;
    public LocalDate claimDate;
    public Double claimAmount;
    public String description;
    public String status;
}
