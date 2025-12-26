package com.example.demo.util;

import org.springframework.stereotype.Component;

@Component
public class HqlQueryHelper {
    public String buildUserSearchQuery(String email) {
        return "FROM User u WHERE u.email = '" + email + "'";
    }
}