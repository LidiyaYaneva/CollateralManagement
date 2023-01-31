package com.example.collateralmanagement.services;

import com.example.collateralmanagement.models.dtos.valuation.AddAppraisalCompanyDTO;

public interface AppraisalCompaniesService {

    void addAppraisalCompany(AddAppraisalCompanyDTO addAppraisalCompanyDTO);

    boolean deleteAppraisalCompany(String companyBULSTAT);

    boolean isEmpty();

    void seedAppraisalCompanies();

}
