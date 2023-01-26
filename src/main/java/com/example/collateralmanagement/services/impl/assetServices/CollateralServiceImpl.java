package com.example.collateralmanagement.services.impl.assetServices;

import com.example.collateralmanagement.models.entities.asset.AddCollateralDTO;
import com.example.collateralmanagement.repositories.CollateralRepository;
import com.example.collateralmanagement.services.CollateralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollateralServiceImpl implements CollateralService {

    private final CollateralRepository collateralRepository;

    @Autowired
    public CollateralServiceImpl(CollateralRepository collateralRepository) {
        this.collateralRepository = collateralRepository;
    }

    @Override
    public void addCollateral(AddCollateralDTO addCollateralDTO) {

    }
}
