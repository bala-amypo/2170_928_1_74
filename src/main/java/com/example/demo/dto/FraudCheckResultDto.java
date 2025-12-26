package com.example.demo.dto;

import java.time.LocalDateTime;

public class FraudCheckResultDto {
    public Long claimId;
    public Boolean isFraudulent;
    public String triggeredRuleName;
    public String rejectionReason;
    public LocalDateTime checkedAt;
}
