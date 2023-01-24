package com.example.collateralmanagement.repositories;

import com.example.collateralmanagement.models.entities.asset.AcquiredAsset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcquiredAssetRepository extends JpaRepository<AcquiredAsset, Long> {

}

