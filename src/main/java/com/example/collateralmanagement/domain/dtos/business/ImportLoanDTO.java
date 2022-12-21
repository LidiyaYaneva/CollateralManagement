package com.example.collateralmanagement.domain.dtos.business;

import com.example.collateralmanagement.domain.entities.business.BankClient;
import com.example.collateralmanagement.domain.entities.property.Collateral;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class ImportLoanDTO {

    private String loanNumber;

    private LocalDate issueDate;

//    @ManyToMany
//    @JoinTable(name = "loans_collaterals",
//            joinColumns = @JoinColumn(name = "collateral_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "loan_id", referencedColumnName = "id"))
//   private Set<Collateral> collaterals;


    private boolean isActive;

    private String riskStatus;

    private Long clientId;

    public ImportLoanDTO() {
    }

    public ImportLoanDTO(String loanNumber, LocalDate issueDate, boolean isActive, String riskStatus, Long clientId) {
        this.loanNumber = loanNumber;
        this.issueDate = issueDate;
        this.isActive = isActive;
        this.riskStatus = riskStatus;
        this.clientId = clientId;
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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getRiskStatus() {
        return riskStatus;
    }

    public void setRiskStatus(String riskStatus) {
        this.riskStatus = riskStatus;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
}
