package com.example.collateralmanagement.repositories;

import com.example.collateralmanagement.models.entities.asset.AcquiredAsset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AcquiredAssetRepository extends JpaRepository<AcquiredAsset, Long> {
    List<AcquiredAsset> findAllByAssetId(Long assetId);
}

