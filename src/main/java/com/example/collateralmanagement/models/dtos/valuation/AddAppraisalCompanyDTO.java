package com.example.collateralmanagement.models.dtos.valuation;

import jakarta.validation.constraints.NotEmpty;

public class AddAppraisalCompanyDTO {
    @NotEmpty
    private String name;
    @NotEmpty
    private String companyBULSTAT;

    public AddAppraisalCompanyDTO() {
    }

    public AddAppraisalCompanyDTO(String name, String companyBULSTAT) {
        this.name = name;
        this.companyBULSTAT = companyBULSTAT;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyBULSTAT() {
        return companyBULSTAT;
    }

    public void setCompanyBULSTAT(String companyBULSTAT) {
        this.companyBULSTAT = companyBULSTAT;
    }
}
