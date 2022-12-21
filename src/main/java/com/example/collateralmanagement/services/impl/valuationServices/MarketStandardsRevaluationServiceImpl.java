package com.example.collateralmanagement.services.impl.valuationServices;

import com.example.collateralmanagement.repositories.MarketStandardsRevaluationRepository;
import com.example.collateralmanagement.services.MarketStandardsRevaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarketStandardsRevaluationServiceImpl implements MarketStandardsRevaluationService {

    private final MarketStandardsRevaluationRepository marketStandardsRevaluationRepository;

    @Autowired
    public MarketStandardsRevaluationServiceImpl(MarketStandardsRevaluationRepository marketStandardsRevaluationRepository) {
        this.marketStandardsRevaluationRepository = marketStandardsRevaluationRepository;
    }
}
