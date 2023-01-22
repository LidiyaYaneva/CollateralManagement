package com.example.collateralmanagement.repositories;

import com.example.collateralmanagement.models.entities.valuation.AppraisalCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppraisalCompanyRepository extends JpaRepository<AppraisalCompany, Long> {

}
