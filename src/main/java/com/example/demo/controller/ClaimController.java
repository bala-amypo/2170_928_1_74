package com.example.demo.controller;

import com.example.demo.model.Claim;
import com.example.demo.service.ClaimService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/claims")
public class ClaimController {

    private final ClaimService service;

    public ClaimController(ClaimService service) {
        this.service = service;
    }

    @PostMapping("/{policyId}")
    public Claim create(@PathVariable Long policyId,
                        @RequestBody Claim claim) {
        return service.createClaim(policyId, claim);
    }

    @GetMapping("/{id}")
    public Claim get(@PathVariable Long id) {
        return service.getClaim(id);
    }

    @GetMapping
    public List<Claim> getAll() {
        return service.getAllClaims();
    }
}
