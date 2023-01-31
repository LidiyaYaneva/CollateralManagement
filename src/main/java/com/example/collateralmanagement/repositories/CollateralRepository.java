package com.example.collateralmanagement.repositories;

import com.example.collateralmanagement.models.entities.asset.Collateral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CollateralRepository extends JpaRepository<Collateral, Long> {
    List<Collateral> findAllByAssetId(Long assetId);
}
