package com.example.collateralmanagement.services;

import com.example.collateralmanagement.models.dtos.valuation.AddAppraisalCompanyDTO;
import jakarta.annotation.PostConstruct;

import java.io.IOException;

public interface AppraisalCompaniesService {

    void addAppraisalCompany(AddAppraisalCompanyDTO addAppraisalCompanyDTO);

    boolean deleteAppraisalCompany(String companyBULSTAT);

    boolean isEmpty();

    String readAppraisalCompaniesFormFile() throws IOException;

    void seedAppraisalCompanies() throws IOException;

    @PostConstruct
    void init() throws IOException;
}
