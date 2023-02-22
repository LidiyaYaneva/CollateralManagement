package com.example.collateralmanagement.models.enums;

public enum ClientType {

    INDIVIDUAL ("Individual"),
    SMALL_BUSINESS_ENTITY ("Small business entity"),
    MIDDLE_SIZE_ENTERPRISE ("Middle-size enterprise"),
    LARGE_ENTERPRISE ("Large enterprise");

    private final String displayValue;

    private ClientType(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }

}
