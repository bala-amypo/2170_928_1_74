package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.ClaimService;
import com.example.demo.exception.ResourceNotFoundException;
import java.time.LocalDate;
import java.util.*;

public class ClaimServiceImpl implements ClaimService {

    private final ClaimRepository claimRepo;
    private final PolicyRepository policyRepo;

    public ClaimServiceImpl(ClaimRepository c, PolicyRepository p) {
        this.claimRepo = c;
        this.policyRepo = p;
    }

    public Claim createClaim(Long policyId, Claim claim) {
        Policy policy = policyRepo.findById(policyId)
                .orElseThrow(() -> new ResourceNotFoundException("Policy not found"));

        if (claim.getClaimAmount() < 0)
            throw new IllegalArgumentException("Invalid claim amount");

        if (claim.getClaimDate().isAfter(LocalDate.now()))
            throw new IllegalArgumentException("Invalid claim date");

        claim.setPolicy(policy);
        return claimRepo.save(claim);
    }

    public Claim getClaim(Long id) {
        return claimRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Claim not found"));
    }
}
