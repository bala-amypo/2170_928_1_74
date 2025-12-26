@ManyToMany
private java.util.Set<FraudRule> suspectedRules = new java.util.HashSet<>();

public void setSuspectedRules(java.util.Set<FraudRule> rules) { this.suspectedRules = rules; }
public java.util.Set<FraudRule> getSuspectedRules() { return suspectedRules; }