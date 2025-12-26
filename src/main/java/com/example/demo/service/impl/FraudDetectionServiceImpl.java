@Override
public void checkFraud(Claim claim) {
    List<FraudRule> rules = fraudRuleRepository.findAll();
    for (FraudRule rule : rules) {
        boolean triggered = false;
        // Example logic: Check if claim amount exceeds rule value
        if ("claimAmount".equals(rule.getConditionField()) && ">".equals(rule.getOperator())) {
            if (claim.getClaimAmount() > Double.parseDouble(rule.getValue())) {
                triggered = true;
            }
        }
        
        if (triggered) {
            claim.getSuspectedRules().add(rule);
            claim.setStatus("SUSPECTED_FRAUD");
        }
    }
    claimRepository.save(claim);
}