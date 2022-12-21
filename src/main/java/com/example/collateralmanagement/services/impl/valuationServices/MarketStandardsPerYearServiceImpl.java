package com.example.collateralmanagement.services.impl.valuationServices;

import com.example.collateralmanagement.repositories.MarketStandardsPerYearRepository;
import com.example.collateralmanagement.services.MarketStandardsPerYearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarketStandardsPerYearServiceImpl implements MarketStandardsPerYearService {

    private final MarketStandardsPerYearRepository marketStandardsPerYearRepository;

    @Autowired
    public MarketStandardsPerYearServiceImpl(MarketStandardsPerYearRepository marketStandardsPerYearRepository) {
        this.marketStandardsPerYearRepository = marketStandardsPerYearRepository;
    }
}
