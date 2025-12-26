public Policy() {} // Keep default

// Add this exact constructor for the tests
public Policy(User user, String policyNumber, String policyType, java.time.LocalDate startDate, java.time.LocalDate endDate) {
    this.user = user;
    this.policyNumber = policyNumber;
    this.policyType = policyType;
    this.startDate = startDate;
    this.endDate = endDate;
}