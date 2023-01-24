package com.example.collateralmanagement.repositories;

import com.example.collateralmanagement.models.entities.asset.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Long> {

}
