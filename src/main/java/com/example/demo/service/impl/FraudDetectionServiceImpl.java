package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.FraudDetectionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public FraudCheckResult evaluateClaim(Long claimId) {
        Claim claim = claimRepository.findById(claimId)
                .orElseThrow(() -> new ResourceNotFoundException("Claim not found"));

        List<FraudRule> rules = fraudRuleRepository.findAll();
        FraudRule triggeredRule = null;

        for (FraudRule rule : rules) {
            if (isRuleMatch(claim, rule)) {
                triggeredRule = rule;
                claim.getSuspectedRules().add(rule);
                break;
            }
        }

        FraudCheckResult result = new FraudCheckResult();
        result.setClaim(claim);
        result.setCheckedAt(LocalDateTime.now());
        
        if (triggeredRule != null) {
            result.setIsFraudulent(true);
            result.setTriggeredRuleName(triggeredRule.getRuleName());
            result.setRejectionReason("Flagged due to " + triggeredRule.getRuleName());
        } else {
            result.setIsFraudulent(false);
            result.setRejectionReason("No suspicious patterns detected");
        }

        return resultRepository.save(result);
    }

    private boolean isRuleMatch(Claim claim, FraudRule rule) {
        if ("claimAmount".equals(rule.getConditionField())) {
            double claimVal = claim.getClaimAmount();
            double ruleVal = Double.parseDouble(rule.getValue());
            return switch (rule.getOperator()) {
                case ">" -> claimVal > ruleVal;
                case "<" -> claimVal < ruleVal;
                case ">=" -> claimVal >= ruleVal;
                case "<=" -> claimVal <= ruleVal;
                case "=" -> claimVal == ruleVal;
                default -> false;
            };
        }
        return false;
    }

    @Override
    public FraudCheckResult getResultByClaim(Long claimId) {
        return resultRepository.findByClaimId(claimId)
                .orElseThrow(() -> new ResourceNotFoundException("Result not found"));
    }
}