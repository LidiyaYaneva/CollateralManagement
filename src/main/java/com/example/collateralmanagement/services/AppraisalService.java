package com.example.collateralmanagement.services;

import com.example.collateralmanagement.models.dtos.valuation.AddAppraisalDTO;

public interface AppraisalService {

    void addAppraisal(AddAppraisalDTO addAppraisalDTO);

    boolean deleteAppraisal (Long id);
}
