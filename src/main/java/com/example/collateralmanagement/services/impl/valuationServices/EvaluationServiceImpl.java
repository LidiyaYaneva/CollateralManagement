package com.example.collateralmanagement.services.impl.valuationServices;

import com.example.collateralmanagement.models.entities.valuation.Evaluation;
import com.example.collateralmanagement.repositories.EvaluationRepository;
import com.example.collateralmanagement.services.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class EvaluationServiceImpl implements EvaluationService {

    private final EvaluationRepository evaluationRepository;

    @Autowired
    public EvaluationServiceImpl(EvaluationRepository evaluationRepository) {
        this.evaluationRepository = evaluationRepository;
    }

    @Override
    public Double getMostRecentMarketValue(Long assetId) {
       Optional<Evaluation> optionalEvaluation = this.evaluationRepository.findTopByAssetIdOrderByDateDesc(assetId);

        return optionalEvaluation.map(Evaluation::getMarketValue).orElse(null);
    }
}
