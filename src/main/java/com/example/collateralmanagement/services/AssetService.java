package com.example.collateralmanagement.services;

import com.example.collateralmanagement.models.dtos.asset.CreateAssetDTO;

public interface AssetService {
    void createAsset (CreateAssetDTO createAssetDTO );

    boolean deleteAssetAndSetRelationsToNULL(Long id);

    boolean deleteAssetAndAllRelationEntities(Long id);
}
