package com.example.collateralmanagement.services;

import com.example.collateralmanagement.models.dtos.asset.CreateAssetDTO;
import com.example.collateralmanagement.models.dtos.asset.DisplayAssetDTO;
import com.example.collateralmanagement.models.dtos.asset.SearchDTO;

import java.util.List;

public interface AssetService {
    void createAsset (CreateAssetDTO createAssetDTO );

    List<DisplayAssetDTO> getAssetsOfClient (String bulstatOrEGN);

    List<DisplayAssetDTO> findAssetsByOwnerName (String owner);

    boolean deleteAssetAndSetRelationsToNULL(Long id);

    boolean deleteAssetAndAllRelationEntities(Long id);

    List<DisplayAssetDTO> findAssetsBySearchInput(SearchDTO searchDTO);
}
