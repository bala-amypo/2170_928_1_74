package com.example.demo.dto;

import java.time.LocalDate;

public class ClaimDto {

    private Long id;
    private Long policyId;
    private LocalDate claimDate;
    private Double claimAmount;
    private String description;
    private String status;

    // getters and setters
}
