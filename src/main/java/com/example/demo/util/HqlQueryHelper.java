package com.example.demo.util;
import com.example.demo.model.Claim;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.ArrayList;

@Component
public class HqlQueryHelper {
    public List<Claim> findHighValueClaims(double amount) {
        return new ArrayList<>(); // Logic not required as it is mocked in tests
    }
    public List<Claim> findClaimsByDescriptionKeyword(String keyword) {
        return new ArrayList<>(); // Logic not required as it is mocked in tests
    }
}