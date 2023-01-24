package com.example.collateralmanagement.repositories;

import com.example.collateralmanagement.models.entities.asset.Collateral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollateralRepository extends JpaRepository<Collateral, Long> {

}
