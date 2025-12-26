package com.example.demo;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.*;
import com.example.demo.security.JwtUtil;
import com.example.demo.util.HqlQueryHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Autowired
    private HqlQueryHelper hqlQueryHelper;

    private User testUser;
    private JwtUtil jwtUtil;

    @BeforeEach
    void setUp() {
        jwtUtil = new JwtUtil(); // Fixed constructor
        testUser = new User();
        testUser.setEmail("test@example.com");
        testUser.setPassword("password123");
        testUser.setRole("ROLE_USER");
    }

    @Test
    void testUserRegistration() {
        User savedUser = userService.registerUser(testUser); // Fixed method name
        assertNotNull(savedUser.getId());
        assertEquals(testUser.getEmail(), savedUser.getEmail());
    }

    @Test
    void testCreatePolicy() {
        User user = userService.registerUser(testUser);
        
        Policy policy = new Policy(); // Fixed: Using setters instead of constructor
        policy.setUser(user);
        policy.setPolicyNumber("POL123");
        policy.setPolicyType("HEALTH");
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
        policy.setStartDate(LocalDate.now());
        policy.setEndDate(LocalDate.now().plusYears(1));
        policy = policyService.createPolicy(policy);

        Claim claim = new Claim(); // Fixed: Using setters
        claim.setPolicy(policy);
        claim.setClaimDate(LocalDate.now());
        claim.setClaimAmount(500.0);
        claim.setDescription("Emergency Room Visit");
        
        Claim savedClaim = claimService.submitClaim(claim);
        assertNotNull(savedClaim.getId());
    }

    @Test
    void testFraudDetection() {
        // Create Rule
        FraudRule rule = new FraudRule();
        rule.setRuleName("High Amount Rule");
        rule.setConditionField("claimAmount");
        rule.setOperator(">");
        rule.setValue("1000");
        rule.setSeverity("HIGH");
        fraudRuleService.createRule(rule);

        // Create Claim
        Claim claim = new Claim();
        claim.setClaimAmount(1500.0);
        claim.setDescription("Expensive Surgery");

        FraudCheckResult result = fraudDetectionService.checkFraud(claim);
        assertTrue(result.isIsFraudulent()); // Fixed method name
    }

    @Test
    void testJwtGeneration() {
        User user = new User();
        user.setId(1L);
        user.setEmail("test@example.com");
        user.setRole("ROLE_USER");

        // Fixed: Passing correct arguments to generateToken
        String token = jwtUtil.generateToken(user.getId(), user.getEmail(), user.getRole());
        assertNotNull(token);
        assertEquals("test@example.com", jwtUtil.extractEmail(token));
    }

    @Test
    void testHqlHelperQueries() {
        Claim claim = new Claim();
        claim.setClaimAmount(2000.0);
        claim.setDescription("Water damage claim");
        claimService.submitClaim(claim);

        List<Claim> highValue = hqlQueryHelper.findHighValueClaims(1000.0);
        assertFalse(highValue.isEmpty());

        List<Claim> keywordSearch = hqlQueryHelper.findClaimsByDescriptionKeyword("Water");
        assertFalse(keywordSearch.isEmpty());
    }
}