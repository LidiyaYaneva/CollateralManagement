package com.example.collateralmanagement.repositories;

import com.example.collateralmanagement.domain.entities.valuation.MarketStandardsPerYear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketStandardsPerYearRepository extends JpaRepository<MarketStandardsPerYear, Long> {

}
