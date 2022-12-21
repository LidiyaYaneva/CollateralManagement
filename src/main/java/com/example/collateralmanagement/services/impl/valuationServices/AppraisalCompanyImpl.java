package com.example.collateralmanagement.services.impl.valuationServices;

import com.example.collateralmanagement.repositories.AppraisalCompanyRepository;
import com.example.collateralmanagement.services.AppraisalCompaniesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppraisalCompanyImpl implements AppraisalCompaniesService {

    private final AppraisalCompanyRepository appraisalCompanyRepository;

    @Autowired
    public AppraisalCompanyImpl(AppraisalCompanyRepository appraisalCompanyRepository) {
        this.appraisalCompanyRepository = appraisalCompanyRepository;
    }
}
