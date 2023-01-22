package com.example.collateralmanagement.models.dtos.business;

public class ImportLoanDTO {

    private String loanNumber;

    private String issueDate;

//    @ManyToMany
//    @JoinTable(name = "loans_collaterals",
//            joinColumns = @JoinColumn(name = "collateral_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "loan_id", referencedColumnName = "id"))
//   private Set<Collateral> collaterals;


    private boolean isActive;

    private String riskStatus;

    private String clientIdNumber;

    public ImportLoanDTO() {
    }

    public ImportLoanDTO(String loanNumber, String issueDate, boolean isActive, String riskStatus, String clientIdNumber) {
        this.loanNumber = loanNumber;
        this.issueDate = issueDate;
        this.isActive = isActive;
        this.riskStatus = riskStatus;
        this.clientIdNumber = clientIdNumber;
        //this.collaterals = new HashSet<>();
    }

    public String getLoanNumber() {
        return loanNumber;
    }

    public void setLoanNumber(String loanNumber) {
        this.loanNumber = loanNumber;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
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

    public String getClientIdNumber() {
        return clientIdNumber;
    }

    public void setClientIdNumber(String clientIdNumber) {
        this.clientIdNumber = clientIdNumber;
    }
}
