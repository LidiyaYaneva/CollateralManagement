package com.example.collateralmanagement.models.dtos.business;

import java.math.BigDecimal;


public class DisplayLoanDTO {

    private String loanNumber;

    private String bankClientName;

    private BigDecimal amount;

    private String riskStatus;


    public DisplayLoanDTO() {
    }

    public String getLoanNumber() {
        return loanNumber;
    }

    public DisplayLoanDTO setLoanNumber(String loanNumber) {
        this.loanNumber = loanNumber;
        return this;
    }

    public String getBankClientName() {
        return bankClientName;
    }

    public DisplayLoanDTO setBankClientName(String bankClientName) {
        this.bankClientName = bankClientName;
        return this;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public DisplayLoanDTO setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public String getRiskStatus() {
        return riskStatus;
    }

    public DisplayLoanDTO setRiskStatus(String riskStatus) {
        this.riskStatus = riskStatus;
        return this;
    }
}
