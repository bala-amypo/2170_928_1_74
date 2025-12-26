public Policy() {} // Required for JPA

public Policy(User user, String policyNumber, String policyType, LocalDate startDate, LocalDate endDate) {
    this.user = user;
    this.policyNumber = policyNumber;
    this.policyType = policyType;
    this.startDate = startDate;
    this.endDate = endDate;
}