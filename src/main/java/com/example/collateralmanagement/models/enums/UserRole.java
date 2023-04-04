package com.example.collateralmanagement.models.enums;

public enum UserRole {

    ADMIN ("Admin"),
    MODERATOR ("Moderator"),
    USER_MANAGER ("Manager"),
    USER_CLIENT_ADVISOR ("Client Advisor"),
    USER_COLLATERAL_RISK ("Collateral expert"),
    USER_BANK_PROPERTY ("Bank property expert");

    private final String displayValue;

    private UserRole(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
