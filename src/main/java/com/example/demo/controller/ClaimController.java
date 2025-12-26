package com.example.demo.controller;

import com.example.demo.dto.ClaimDto;
import com.example.demo.model.Claim;
import com.example.demo.service.ClaimService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/claims")
public class ClaimController {
    private final ClaimService claimService;

    public ClaimController(ClaimService claimService) {
        this.claimService = claimService;
    }

    @PostMapping("/{policyId}")
    public ResponseEntity<ClaimDto> createClaim(@PathVariable Long policyId, @RequestBody ClaimDto claimDto) {
        Claim claim = new Claim();
        claim.setClaimDate(claimDto.getClaimDate());
        claim.setClaimAmount(claimDto.getClaimAmount());
        claim.setDescription(claimDto.getDescription());
        
        Claim savedClaim = claimService.createClaim(policyId, claim);
        return ResponseEntity.ok(convertToDto(savedClaim));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClaimDto> getClaim(@PathVariable Long id) {
        Claim claim = claimService.getClaim(id);
        return ResponseEntity.ok(convertToDto(claim));
    }

    @GetMapping
    public ResponseEntity<List<ClaimDto>> getAllClaims() {
        List<ClaimDto> claims = claimService.getAllClaims().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(claims);
    }

    private ClaimDto convertToDto(Claim claim) {
        ClaimDto dto = new ClaimDto();
        dto.setId(claim.getId());
        dto.setPolicyId(claim.getPolicy().getId());
        dto.setClaimDate(claim.getClaimDate());
        dto.setClaimAmount(claim.getClaimAmount());
        dto.setDescription(claim.getDescription());
        dto.setStatus(claim.getStatus());
        return dto;
    }
}