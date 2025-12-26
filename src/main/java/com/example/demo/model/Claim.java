@ManyToMany
    @JoinTable(
      name = "claim_fraud_rules", 
      joinColumns = @JoinColumn(name = "claim_id"), 
      inverseJoinColumns = @JoinColumn(name = "fraud_rule_id"))
    private Set<FraudRule> suspectedRules = new HashSet<>();