package com.example.collateralmanagement.repositories;

import com.example.collateralmanagement.models.entities.valuation.MarketStandardsRevaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketStandardsRevaluationRepository extends JpaRepository<MarketStandardsRevaluation, Long> {

}
