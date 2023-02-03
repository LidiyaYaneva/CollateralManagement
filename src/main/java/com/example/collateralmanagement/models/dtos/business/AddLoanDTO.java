package com.example.collateralmanagement.models.dtos.business;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;


import java.math.BigDecimal;
import java.time.LocalDate;

public class AddLoanDTO {
    @NotEmpty
    private String loanNumber;
    @NotEmpty
    @PastOrPresent
    private LocalDate issueDate;

//    @ManyToMany
//    @JoinTable(name = "loans_collaterals",
//            joinColumns = @JoinColumn(name = "collateral_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "loan_id", referencedColumnName = "id"))
//   private Set<Collateral> collaterals;

    @NotEmpty
    private Boolean active;

    private String riskStatus;
    @NotEmpty
    @Positive
    private BigDecimal amount;
    @NotEmpty
    private String clientIdNumber;

    public AddLoanDTO() {
    }

    public AddLoanDTO(String loanNumber, LocalDate issueDate, boolean active, String riskStatus, BigDecimal amount, String clientIdNumber) {
        this.loanNumber = loanNumber;
        this.issueDate = issueDate;
        this.active = active;
        this.riskStatus = riskStatus;
        this.clientIdNumber = clientIdNumber;
        this.amount= amount;
        //this.collaterals = new HashSet<>();
    }

    public String getLoanNumber() {
        return loanNumber;
    }

    public void setLoanNumber(String loanNumber) {
        this.loanNumber = loanNumber;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getRiskStatus() {
        return riskStatus;
    }

    public void setRiskStatus(String riskStatus) {
        this.riskStatus = riskStatus;
    }

    public String getClientIdNumber() {
        return clientIdNumber;
    }

    public void setClientIdNumber(String clientIdNumber) {
        this.clientIdNumber = clientIdNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
