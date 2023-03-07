package com.example.collateralmanagement.services;

import com.example.collateralmanagement.models.dtos.asset.CreateCollateralDTO;
import com.example.collateralmanagement.models.dtos.asset.DisplayCollateralDTO;
import com.example.collateralmanagement.models.dtos.asset.SearchDTO;

import java.util.List;

public interface CollateralService {

    void addCollateral(CreateCollateralDTO createCollateralDTO);

    boolean deleteCollateral(Long id);

    List<DisplayCollateralDTO> findCollateralsOfRecentLoans();

    List<DisplayCollateralDTO> displayCollateralsBySearchInput(SearchDTO searchDTO);
}
