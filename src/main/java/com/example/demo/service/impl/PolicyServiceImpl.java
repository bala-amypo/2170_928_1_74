package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.PolicyService;
import com.example.demo.exception.ResourceNotFoundException;
import java.util.*;

public class PolicyServiceImpl implements PolicyService {

    private final PolicyRepository policyRepo;
    private final UserRepository userRepo;

    public PolicyServiceImpl(PolicyRepository p, UserRepository u) {
        this.policyRepo = p;
        this.userRepo = u;
    }

    public Policy createPolicy(Long userId, Policy policy) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        if (policyRepo.existsByPolicyNumber(policy.getPolicyNumber()))
            throw new IllegalArgumentException("Policy number already exists");

        if (!policy.getEndDate().isAfter(policy.getStartDate()))
            throw new IllegalArgumentException("Invalid policy dates");

        policy.setUser(user);
        return policyRepo.save(policy);
    }

    public List<Policy> getPoliciesByUser(Long userId) {
        return policyRepo.findByUserId(userId);
    }
}
