package com.example.demo.service.impl;

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
}