package com.example.demo.service;
import com.example.demo.model.FraudCheckResult;

public interface FraudDetectionService {
    FraudCheckResult evaluateClaim(Long claimId); // Added
    FraudCheckResult getResultByClaim(Long claimId); // Added
}