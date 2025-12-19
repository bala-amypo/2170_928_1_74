package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.FraudDetectionService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FraudDetectionServiceImpl implements FraudDetectionService {

    private final ClaimRepository claimRepository;
    private final FraudRuleRepository fraudRuleRepository;
    private final FraudCheckResultRepository resultRepository;

    public FraudDetectionServiceImpl(ClaimRepository claimRepository,
                                     FraudRuleRepository fraudRuleRepository,
                                     FraudCheckResultRepository resultRepository) {
        this.claimRepository = claimRepository;
        this.fraudRuleRepository = fraudRuleRepository;
        this.resultRepository = resultRepository;
    }

    @Override
    public FraudCheckResult evaluateClaim(Long claimId) {
        Claim claim = claimRepository.findById(claimId)
                .orElseThrow(() -> new ResourceNotFoundException("Claim not found"));

        List<FraudRule> rules = fraudRuleRepository.findAll();

        for (FraudRule rule : rules) {
            if ("claimAmount".equals(rule.getConditionField())) {
                double threshold = Double.parseDouble(rule.getValue());

                if (claim.getClaimAmount() > threshold) {
                    FraudCheckResult result = new FraudCheckResult(
                            claim, true, rule.getRuleName(),
                            "Claim amount exceeds allowed limit",
                            LocalDateTime.now()
                    );
                    return resultRepository.save(result);
                }
            }
        }

        FraudCheckResult cleanResult = new FraudCheckResult(
                claim, false, null, null, LocalDateTime.now()
        );
        return resultRepository.save(cleanResult);
    }

    @Override
    public FraudCheckResult getResultByClaim(Long claimId) {
        return resultRepository.findByClaimId(claimId)
                .orElseThrow(() -> new ResourceNotFoundException("Result not found"));
    }
}
