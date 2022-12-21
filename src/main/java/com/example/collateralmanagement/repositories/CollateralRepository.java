package com.example.collateralmanagement.repositories;

import com.example.collateralmanagement.domain.entities.property.Collateral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollateralRepository extends JpaRepository<Collateral, Long> {

}
