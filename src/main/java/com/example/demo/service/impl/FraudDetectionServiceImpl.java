package com.example.demo.service.impl;

import com.example.demo.model.Claim;
import com.example.demo.model.FraudCheckResult;
import com.example.demo.repository.ClaimRepository;
import com.example.demo.repository.FraudRuleRepository;
import com.example.demo.repository.FraudCheckResultRepository;
import com.example.demo.service.FraudDetectionService;
import org.springframework.stereotype.Service;

@Service
public class FraudDetectionServiceImpl implements FraudDetectionService {
    private final ClaimRepository claimRepo;
    private final FraudRuleRepository ruleRepo;
    private final FraudCheckResultRepository resultRepo;

    public FraudDetectionServiceImpl(ClaimRepository claimRepo, FraudRuleRepository ruleRepo, FraudCheckResultRepository resultRepo) {
        this.claimRepo = claimRepo;
        this.ruleRepo = ruleRepo;
        this.resultRepo = resultRepo;
    }

    @Override
    public FraudCheckResult evaluateClaim(Long claimId) {
        // Simple mock implementation to satisfy controller compilation
        // Real logic would go here
        FraudCheckResult result = new FraudCheckResult();
        result.setMatchedRules("No Rules");
        return resultRepo.save(result);
    }

    @Override
    public FraudCheckResult getResultByClaim(Long claimId) {
        // Mock implementation
        return resultRepo.findById(claimId).orElse(null);
    }
}