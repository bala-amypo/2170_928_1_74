package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.FraudDetectionService;
import com.example.demo.exception.ResourceNotFoundException;

import java.time.LocalDateTime;
import java.util.*;

public class FraudDetectionServiceImpl implements FraudDetectionService {

    private final ClaimRepository claimRepo;
    private final FraudRuleRepository ruleRepo;
    private final FraudCheckResultRepository resultRepo;

    public FraudDetectionServiceImpl(
            ClaimRepository c,
            FraudRuleRepository r,
            FraudCheckResultRepository res) {
        this.claimRepo = c;
        this.ruleRepo = r;
        this.resultRepo = res;
    }

    public FraudCheckResult evaluateClaim(Long claimId) {
        Claim claim = claimRepo.findById(claimId)
                .orElseThrow(() -> new ResourceNotFoundException("Claim not found"));

        FraudCheckResult result = new FraudCheckResult();
        result.setMatchedRules("");
        resultRepo.save(result);
        return result;
    }

    public FraudCheckResult getResultByClaim(Long claimId) {
        return resultRepo.findByClaimId(claimId)
                .orElseThrow(() -> new ResourceNotFoundException("Result not found"));
    }
}
