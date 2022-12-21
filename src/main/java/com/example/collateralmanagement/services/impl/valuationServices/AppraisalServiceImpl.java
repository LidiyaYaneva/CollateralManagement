package com.example.collateralmanagement.services.impl.valuationServices;

import com.example.collateralmanagement.repositories.AppraisalRepository;
import com.example.collateralmanagement.services.AppraisalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppraisalServiceImpl  implements AppraisalService {


    private final AppraisalRepository appraisalRepository;

    @Autowired
    public AppraisalServiceImpl(AppraisalRepository appraisalRepository) {
        this.appraisalRepository = appraisalRepository;
    }
}
