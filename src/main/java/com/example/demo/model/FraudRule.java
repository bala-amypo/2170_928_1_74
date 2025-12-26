public FraudRule() {} // Keep default

// Add this exact constructor for the tests
public FraudRule(String ruleName, String conditionField, String operator, String value, String description) {
    this.ruleName = ruleName;
    this.conditionField = conditionField;
    this.operator = operator;
    this.value = value;
    this.description = description;
}