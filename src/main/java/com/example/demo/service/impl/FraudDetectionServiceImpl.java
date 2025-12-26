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
    private final FraudRuleRepository ruleRepository;
    private final FraudCheckResultRepository resultRepository;

    public FraudDetectionServiceImpl(ClaimRepository claimRepository, FraudRuleRepository ruleRepository, FraudCheckResultRepository resultRepository) {
        this.claimRepository = claimRepository;
        this.ruleRepository = ruleRepository;
        this.resultRepository = resultRepository;
    }

    @Override
    public FraudCheckResult evaluateClaim(Long claimId) {
        Claim claim = claimRepository.findById(claimId)
                .orElseThrow(() -> new ResourceNotFoundException("Claim not found"));
        
        List<FraudRule> rules = ruleRepository.findAll();
        FraudCheckResult result = new FraudCheckResult();
        result.setClaim(claim);
        result.setIsFraudulent(false);
        result.setCheckedAt(LocalDateTime.now());

        for (FraudRule rule : rules) {
            if ("claimAmount".equals(rule.getConditionField())) {
                double threshold = Double.parseDouble(rule.getValue());
                boolean triggered = switch (rule.getOperator()) {
                    case ">" -> claim.getClaimAmount() > threshold;
                    case "<" -> claim.getClaimAmount() < threshold;
                    case ">=" -> claim.getClaimAmount() >= threshold;
                    case "<=" -> claim.getClaimAmount() <= threshold;
                    case "=" -> claim.getClaimAmount() == threshold;
                    default -> false;
                };

                if (triggered) {
                    result.setIsFraudulent(true);
                    result.setTriggeredRuleName(rule.getRuleName());
                    result.setRejectionReason("Claim flagged by rule: " + rule.getRuleName());
                    claim.getSuspectedRules().add(rule);
                    break;
                }
            }
        }
        return resultRepository.save(result);
    }

    @Override
    public FraudCheckResult getResultByClaim(Long claimId) {
        return resultRepository.findByClaimId(claimId)
                .orElseThrow(() -> new ResourceNotFoundException("Result not found"));
    }
}