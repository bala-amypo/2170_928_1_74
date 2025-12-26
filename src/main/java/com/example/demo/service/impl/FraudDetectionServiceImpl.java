package com.example.demo.service.impl;

import com.example.demo.model.Claim;
import com.example.demo.model.FraudRule;
import com.example.demo.repository.ClaimRepository;
import com.example.demo.repository.FraudRuleRepository;
import com.example.demo.service.FraudDetectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FraudDetectionServiceImpl implements FraudDetectionService {

    @Autowired
    private FraudRuleRepository fraudRuleRepository;

    @Autowired
    private ClaimRepository claimRepository;

    @Override
    public void checkFraud(Claim claim) {
        List<FraudRule> rules = fraudRuleRepository.findAll();
        for (FraudRule rule : rules) {
            boolean triggered = false;
            if ("claimAmount".equals(rule.getConditionField()) && ">".equals(rule.getOperator())) {
                try {
                    if (claim.getClaimAmount() > Double.parseDouble(rule.getValue())) {
                        triggered = true;
                    }
                } catch (Exception e) {
                    // Handle parsing error if necessary
                }
            }
            
            if (triggered) {
                claim.getSuspectedRules().add(rule);
                claim.setStatus("SUSPECTED_FRAUD");
            }
        }
        claimRepository.save(claim);
    }
}