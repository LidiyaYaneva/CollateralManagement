package com.example.collateralmanagement.repositories;

import com.example.collateralmanagement.models.entities.valuation.Appraisal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppraisalRepository extends JpaRepository<Appraisal, Long> {

}
