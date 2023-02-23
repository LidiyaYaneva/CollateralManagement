package com.example.collateralmanagement.models.dtos.business;

import com.example.collateralmanagement.models.validation.ExistingClient;
import jakarta.validation.constraints.*;


import java.math.BigDecimal;
import java.time.LocalDate;

public class AddLoanDTO {
    @NotBlank
    @Size(min = 2, max = 30)
    private String loanNumber;

    @NotBlank
    @ExistingClient
    private String clientBulstatOrEGN;

    @NotNull
    @Positive
    private BigDecimal amount;
    @NotNull
    @PastOrPresent
    private LocalDate issueDate;

//    @ManyToMany
//    @JoinTable(name = "loans_collaterals",
//            joinColumns = @JoinColumn(name = "collateral_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "loan_id", referencedColumnName = "id"))
//   private Set<Collateral> collaterals;

    private Boolean active;

    private String riskStatus;


    public AddLoanDTO() {
    }

    public AddLoanDTO(String loanNumber, LocalDate issueDate, boolean active, String riskStatus, BigDecimal amount, String clientIdNumber) {
        this.loanNumber = loanNumber;
        this.issueDate = issueDate;
        this.active = active;
        this.riskStatus = riskStatus;
        this.clientBulstatOrEGN = clientIdNumber;
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

    public String getClientBulstatOrEGN() {
        return clientBulstatOrEGN;
    }

    public void setClientBulstatOrEGN(String clientBulstatOrEGN) {
        this.clientBulstatOrEGN = clientBulstatOrEGN;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
