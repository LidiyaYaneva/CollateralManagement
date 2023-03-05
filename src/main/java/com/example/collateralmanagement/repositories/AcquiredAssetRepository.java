package com.example.collateralmanagement.repositories;

import com.example.collateralmanagement.models.dtos.asset.DisplayAcquiredAssetDTO;
import com.example.collateralmanagement.models.entities.asset.AcquiredAsset;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public interface AcquiredAssetRepository extends JpaRepository<AcquiredAsset, Long> {
    List<AcquiredAsset> findAllByAssetId(Long assetId);

    List<AcquiredAsset> findAllByActive (boolean active);

    Page<AcquiredAsset> findAllBySaleDateIsNull(PageRequest pageRequest);

//    @Query("SELECT new com.example.collateralmanagement.models.dtos.asset.DisplayAcquiredAssetDTO (aa.id, ass.id, ass.description,ass.keyword, aa.acquisitionDate, aa.saleDate, aa.managementStrategy)  " +
//            "FROM AcquiredAsset AS aa JOIN Asset AS ass " +
//            "WHERE aa.active IS TRUE")
//    List<DisplayAcquiredAssetDTO> findAllActive ();

}

