package com.example.collateralmanagement.services.impl.valuationServices;

import com.example.collateralmanagement.repositories.EvaluationRepository;
import com.example.collateralmanagement.services.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EvaluationServiceImpl implements EvaluationService {

    private final EvaluationRepository evaluationRepository;

    @Autowired
    public EvaluationServiceImpl(EvaluationRepository evaluationRepository) {
        this.evaluationRepository = evaluationRepository;
    }
}
