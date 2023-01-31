package com.example.collateralmanagement.services;

import com.example.collateralmanagement.models.entities.asset.AddCollateralDTO;

public interface CollateralService {

    void addCollateral(AddCollateralDTO addCollateralDTO);

    boolean deleteCollateral(Long id);
}
