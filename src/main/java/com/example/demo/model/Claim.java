private String status;

    @ManyToMany
    private java.util.Set<FraudRule> suspectedRules = new java.util.HashSet<>();

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public java.util.Set<FraudRule> getSuspectedRules() { return suspectedRules; }
    public void setSuspectedRules(java.util.Set<FraudRule> suspectedRules) { this.suspectedRules = suspectedRules; }