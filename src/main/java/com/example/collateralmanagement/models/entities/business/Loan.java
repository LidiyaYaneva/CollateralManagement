package com.example.collateralmanagement.models.entities.business;

import com.example.collateralmanagement.models.entities.asset.Collateral;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="loans")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "loan_number", nullable = false, unique = true)
    private String loanNumber;

    @Column(name = "issue_date", nullable = false)
    private LocalDate issueDate;

    @Column(name = "is_active",nullable = false)
    private boolean isActive;

    @Column(name = "risk_status")
    private String riskStatus;

    @Column
    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private BankClient client;

    @ManyToMany
    @JoinTable(name = "loans_collaterals",
            joinColumns = @JoinColumn(name = "collateral_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "loan_id", referencedColumnName = "id"))
    private Set<Collateral> collaterals;

    public Loan () {
        this.collaterals = new HashSet<>();
    }

    public Loan(String loanNumber, LocalDate issueDate, boolean isActive, String riskStatus, BigDecimal amount) {
        this();
        this.loanNumber = loanNumber;
        this.issueDate = issueDate;
        this.isActive = isActive;
        this.riskStatus = riskStatus;
        this.amount = amount;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set<Collateral> getCollaterals() {
        return collaterals;
    }

    public void setCollaterals(Set<Collateral> collaterals) {
        this.collaterals = collaterals;
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

    public BankClient getClient() {
        return client;
    }

    public void setClient(BankClient client) {
        this.client = client;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Loan setClientAndReturnLoan (BankClient bankClient){
        this.client = bankClient;
        return this;
    }

}
