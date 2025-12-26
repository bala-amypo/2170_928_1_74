package com.example.demo;

import com.example.demo.model.*;
import com.example.demo.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class DemoApplicationTests {

    @Autowired
    private UserService userService;
    @Autowired
    private PolicyService policyService;

    @Test
    void testPolicyCreationFlow() {
        User user = new User();
        user.setEmail("tester@demo.com");
        user.setPassword("pass");
        user = userService.registerUser(user);

        Policy policy = new Policy();
        policy.setPolicyNumber("POL-999");
        
        // Matches required: java.lang.Long, com.example.demo.model.Policy
        Policy savedPolicy = policyService.createPolicy(user.getId(), policy); 
        
        assertNotNull(savedPolicy.getId());
        assertEquals("POL-999", savedPolicy.getPolicyNumber());
    }
}