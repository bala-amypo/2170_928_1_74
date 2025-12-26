package com.example.demo;

import com.example.demo.model.*;
import com.example.demo.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private UserService userService;
    @Autowired
    private PolicyService policyService;

    @Test
    void testWorkflow() {
        User user = new User();
        user.setEmail("test@test.com");
        user = userService.registerUser(user);

        Policy policy = new Policy();
        policy.setPolicyNumber("P100");
        // We pass the USER ID and the POLICY object separately to match your Service
        Policy savedPolicy = policyService.createPolicy(user.getId(), policy); 
        
        assertNotNull(savedPolicy.getId());
    }
}