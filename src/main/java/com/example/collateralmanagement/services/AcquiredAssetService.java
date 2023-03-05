package com.example.collateralmanagement.services;

import com.example.collateralmanagement.models.dtos.asset.AddAcquiredAssetDTO;
import com.example.collateralmanagement.models.dtos.asset.DisplayAcquiredAssetDTO;

import java.util.List;

public interface AcquiredAssetService {

    void addAcquiredAsset (AddAcquiredAssetDTO addAcquiredAssetDTO);

    boolean deleteAcquiredAsset (Long id);

    List<DisplayAcquiredAssetDTO> findAllNotSoldActive();

    //List<DisplayAcquiredAssetDTO> findAllActive();
}
