public Claim() {} 

public Claim(Policy policy, LocalDate claimDate, double claimAmount, String description) {
    this.policy = policy;
    this.claimDate = claimDate;
    this.claimAmount = claimAmount;
    this.description = description;
}