package com.example.demo;

import com.example.demo.model.*;
import com.example.demo.service.*;
import com.example.demo.security.JwtUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class DemoApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    private PolicyService policyService;

    @Autowired
    private ClaimService claimService;

    @Autowired
    private FraudRuleService fraudRuleService;

    @Autowired
    private FraudDetectionService fraudDetectionService;

    private User testUser;
    private JwtUtil jwtUtil;

    @BeforeEach
    void setUp() {
        jwtUtil = new JwtUtil(); 
        testUser = new User();
        testUser.setEmail("test@example.com");
        testUser.setPassword("password123");
        testUser.setRole("ROLE_USER");
    }

    @Test
    void testUserRegistration() {
        User savedUser = userService.registerUser(testUser); 
        assertNotNull(savedUser.getId());
    }

    @Test
    void testCreatePolicy() {
        User user = userService.registerUser(testUser);
        
        Policy policy = new Policy();
        policy.setUser(user);
        policy.setPolicyNumber("POL123");
        policy.setStartDate(LocalDate.now());
        policy.setEndDate(LocalDate.now().plusYears(1));
        
        Policy savedPolicy = policyService.createPolicy(policy);
        assertNotNull(savedPolicy.getId());
    }

    @Test
    void testSubmitClaim() {
        User user = userService.registerUser(testUser);
        Policy policy = new Policy();
        policy.setUser(user);
        policy.setPolicyNumber("POL456");
        policy = policyService.createPolicy(policy);

        Claim claim = new Claim();
        claim.setPolicy(policy);
        claim.setClaimAmount(500.0);
        claim.setClaimDate(LocalDate.now());
        
        Claim savedClaim = claimService.submitClaim(claim);
        assertNotNull(savedClaim.getId());
    }

    @Test
    void testFraudDetection() {
        FraudRule rule = new FraudRule();
        rule.setRuleName("High Amount");
        rule.setConditionField("claimAmount");
        rule.setOperator(">");
        rule.setValue("1000");
        fraudRuleService.createRule(rule);

        Claim claim = new Claim();
        claim.setClaimAmount(1500.0);

        FraudCheckResult result = fraudDetectionService.checkFraud(claim);
        assertTrue(result.isIsFraudulent()); 
    }

    @Test
    void testJwtGeneration() {
        User user = new User();
        user.setId(1L);
        user.setEmail("test@example.com");
        user.setRole("ROLE_USER");

        String token = jwtUtil.generateToken(user.getId(), user.getEmail(), user.getRole());
        assertNotNull(token);
    }
}