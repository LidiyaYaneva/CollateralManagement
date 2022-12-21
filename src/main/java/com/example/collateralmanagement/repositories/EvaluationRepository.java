package com.example.collateralmanagement.repositories;

import com.example.collateralmanagement.domain.entities.valuation.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {

}
