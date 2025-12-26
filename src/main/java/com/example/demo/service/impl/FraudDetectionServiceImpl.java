package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import com.example.demo.service.FraudDetectionService;
import com.example.demo.repository.*;
import com.example.demo.model.*;
import com.example.demo.exception.ResourceNotFoundException;

@Service
public class FraudDetectionServiceImpl implements FraudDetectionService {

    private final ClaimRepository claimRepo;
    private final FraudRuleRepository ruleRepo;
    private final FraudCheckResultRepository resultRepo;

    public FraudDetectionServiceImpl(
            ClaimRepository claimRepo,
            FraudRuleRepository ruleRepo,
            FraudCheckResultRepository resultRepo) {
        this.claimRepo = claimRepo;
        this.ruleRepo = ruleRepo;
        this.resultRepo = resultRepo;
    }

    @Override
    public FraudCheckResult evaluateClaim(Long claimId) {
        Claim claim = claimRepo.findById(claimId)
                .orElseThrow(() -> new ResourceNotFoundException("Claim not found"));

        for (FraudRule rule : ruleRepo.findAll()) {
            if ("claimAmount".equals(rule.getConditionField())) {
                double threshold = Double.parseDouble(rule.getValue());
                if (claim.getClaimAmount() > threshold) {
                    FraudCheckResult result =
                        new FraudCheckResult(
                            claim, true,
                            rule.getRuleName(),
                            "Claim amount exceeds threshold",
                            LocalDateTime.now());
                    return resultRepo.save(result);
                }
            }
        }

        return resultRepo.save(
            new FraudCheckResult(claim, false, null, null, LocalDateTime.now())
        );
    }

    @Override
    public FraudCheckResult getResultByClaim(Long claimId) {
        return resultRepo.findByClaimId(claimId)
                .orElseThrow(() -> new ResourceNotFoundException("Result not found"));
    }
}
