package com.example.demo.util;

import org.springframework.stereotype.Component;

@Component
public class HqlQueryHelper {

    // Method to find claims above a certain amount
    public String findHighValueClaims(double minAmount) {
        return "FROM Claim c WHERE c.claimAmount > " + minAmount;
    }

    // Method to search claims by description keyword
    public String findClaimsByDescriptionKeyword(String keyword) {
        return "FROM Claim c WHERE c.description LIKE '%" + keyword + "%'";
    }

    public String buildUserSearchQuery(String email) {
        return "FROM User u WHERE u.email = '" + email + "'";
    }
}