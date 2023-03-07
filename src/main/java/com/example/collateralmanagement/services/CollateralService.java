package com.example.collateralmanagement.services;

import com.example.collateralmanagement.models.dtos.asset.CreateCollateralDTO;
import com.example.collateralmanagement.models.dtos.asset.DisplayCollateralDTO;

import java.util.List;

public interface CollateralService {

    void addCollateral(CreateCollateralDTO createCollateralDTO);

    boolean deleteCollateral(Long id);

    List<DisplayCollateralDTO> findCollateralsOfRecentLoans();
}
