package com.example.demo.service.impl;

import com.example.demo.model.Claim;
import com.example.demo.model.Policy;
import com.example.demo.repository.ClaimRepository;
import com.example.demo.repository.PolicyRepository;
import com.example.demo.service.ClaimService;
import com.example.demo.exception.ResourceNotFoundException;

import java.time.LocalDate;
import java.util.List;

public class ClaimServiceImpl implements ClaimService {

    private final ClaimRepository claimRepo;
    private final PolicyRepository policyRepo;

    public ClaimServiceImpl(ClaimRepository claimRepo, PolicyRepository policyRepo) {
        this.claimRepo = claimRepo;
        this.policyRepo = policyRepo;
    }

    @Override
    public Claim createClaim(Long policyId, Claim claim) {
        Policy policy = policyRepo.findById(policyId)
                .orElseThrow(() -> new ResourceNotFoundException("Policy not found"));

        if (claim.getClaimAmount() < 0) {
            throw new IllegalArgumentException("Invalid claim amount");
        }

        if (claim.getClaimDate().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Invalid claim date");
        }

        claim.setPolicy(policy);
        return claimRepo.save(claim);
    }

    @Override
    public Claim getClaim(Long claimId) {
        return claimRepo.findById(claimId)
                .orElseThrow(() -> new ResourceNotFoundException("Claim not found"));
    }

    @Override
    public List<Claim> getAllClaims() {
        return claimRepo.findAll();
    }
}
