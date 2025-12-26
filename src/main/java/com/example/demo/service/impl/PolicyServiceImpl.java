package com.example.demo.service.impl;

import com.example.demo.model.Policy;
import com.example.demo.model.User;
import com.example.demo.repository.PolicyRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.PolicyService;
import com.example.demo.exception.ResourceNotFoundException;

import java.util.List;

public class PolicyServiceImpl implements PolicyService {

    private final PolicyRepository policyRepo;
    private final UserRepository userRepo;

    public PolicyServiceImpl(PolicyRepository policyRepo, UserRepository userRepo) {
        this.policyRepo = policyRepo;
        this.userRepo = userRepo;
    }

    @Override
    public Policy createPolicy(Long userId, Policy policy) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        if (policyRepo.existsByPolicyNumber(policy.getPolicyNumber())) {
            throw new IllegalArgumentException("Policy number already exists");
        }

        if (!policy.getEndDate().isAfter(policy.getStartDate())) {
            throw new IllegalArgumentException("Invalid policy dates");
        }

        policy.setUser(user);
        return policyRepo.save(policy);
    }

    @Override
    public List<Policy> getPoliciesByUser(Long userId) {
        return policyRepo.findByUserId(userId);
    }

    @Override
    public Policy getPolicy(Long id) {
        return policyRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Policy not found"));
    }
}
