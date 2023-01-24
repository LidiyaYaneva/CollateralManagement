package com.example.collateralmanagement.services.impl.assetServices;

import com.example.collateralmanagement.repositories.CollateralTypeRepository;
import com.example.collateralmanagement.services.CollateralTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollateralTypeServiceImpl implements CollateralTypeService {

    private final CollateralTypeRepository collateralTypeRepository;
    @Autowired
    public CollateralTypeServiceImpl(CollateralTypeRepository collateralTypeRepository) {
        this.collateralTypeRepository = collateralTypeRepository;
    }
}
