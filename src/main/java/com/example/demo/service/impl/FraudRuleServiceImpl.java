package com.example.demo.service.impl;

import com.example.demo.model.FraudRule;
import com.example.demo.repository.FraudRuleRepository;
import com.example.demo.service.FraudRuleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class FraudRuleServiceImpl implements FraudRuleService {

    private static final Set<String> VALID_SEVERITY =
            Set.of("LOW", "MEDIUM", "HIGH");

    private final FraudRuleRepository fraudRuleRepository;

    public FraudRuleServiceImpl(FraudRuleRepository fraudRuleRepository) {
        this.fraudRuleRepository = fraudRuleRepository;
    }

    @Override
    public FraudRule addRule(FraudRule rule) {
        if (fraudRuleRepository.findByRuleName(rule.getRuleName()).isPresent()) {
            throw new IllegalArgumentException("Invalid or duplicate rule name");
        }

        if (!VALID_SEVERITY.contains(rule.getSeverity())) {
            throw new IllegalArgumentException("Invalid severity");
        }

        return fraudRuleRepository.save(rule);
    }

    @Override
    public List<FraudRule> getAllRules() {
        return fraudRuleRepository.findAll();
    }
}
