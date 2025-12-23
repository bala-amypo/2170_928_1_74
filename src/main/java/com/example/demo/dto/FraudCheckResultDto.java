package com.example.demo.dto;

import java.time.LocalDateTime;

public class FraudCheckResultDto {

    private Long claimId;
    private Boolean isFraudulent;
    private String triggeredRuleName;
    private String rejectionReason;
    private LocalDateTime checkedAt;

    // getters and setters
}
