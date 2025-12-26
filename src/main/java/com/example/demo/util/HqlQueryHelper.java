package com.example.demo.util;

import com.example.demo.model.Claim;
import com.example.demo.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class HqlQueryHelper {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Claim> findHighValueClaims(double minAmount) {
        String hql = "FROM Claim c WHERE c.claimAmount > :minAmount";
        return entityManager.createQuery(hql, Claim.class)
                .setParameter("minAmount", minAmount)
                .getResultList();
    }

    public List<Claim> findClaimsByDescriptionKeyword(String keyword) {
        String hql = "FROM Claim c WHERE c.description LIKE :keyword";
        return entityManager.createQuery(hql, Claim.class)
                .setParameter("keyword", "%" + keyword + "%")
                .getResultList();
    }

    public List<User> buildUserSearchQuery(String email) {
        String hql = "FROM User u WHERE u.email = :email";
        return entityManager.createQuery(hql, User.class)
                .setParameter("email", email)
                .getResultList();
    }
}