package com.example.collateralmanagement.repositories;

import com.example.collateralmanagement.domain.entities.valuation.ValuationMethodsDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValuationMethodDetailsRepository extends JpaRepository<ValuationMethodsDetails, Long> {

}
