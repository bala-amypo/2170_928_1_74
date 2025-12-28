package com.example.demo.service.impl;

import com.example.demo.model.FraudRule;
import com.example.demo.repository.FraudRuleRepository;
import com.example.demo.service.FraudRuleService;
import org.springframework.stereotype.Service;
import java.util.Set;

@Service
public class FraudRuleServiceImpl implements FraudRuleService {
    private final FraudRuleRepository fraudRuleRepository;

    public FraudRuleServiceImpl(FraudRuleRepository fraudRuleRepository) {
        this.fraudRuleRepository = fraudRuleRepository;
    }

    @Override
    public FraudRule addRule(FraudRule rule) {
        Set<String> validLevels = Set.of("HIGH", "MEDIUM", "LOW");
        if (!validLevels.contains(rule.getSeverity())) {
            throw new IllegalArgumentException("Invalid severity");
        }
        return fraudRuleRepository.save(rule);
    }
}