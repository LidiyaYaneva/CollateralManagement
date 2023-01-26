package com.example.collateralmanagement.services.impl.valuationServices;

import com.example.collateralmanagement.models.dtos.valuation.AddDetailsDTO;
import com.example.collateralmanagement.repositories.ValuationMethodDetailsRepository;
import com.example.collateralmanagement.services.ValuationMethodDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValuationMethodDetailsServiceImpl implements ValuationMethodDetailsService {

    private final ValuationMethodDetailsRepository valuationMethodDetailsRepository;

    @Autowired
    public ValuationMethodDetailsServiceImpl(ValuationMethodDetailsRepository valuationMethodDetailsRepository) {
        this.valuationMethodDetailsRepository = valuationMethodDetailsRepository;
    }

    @Override
    public void addDetails(AddDetailsDTO addDetailsDTO) {

    }
}
