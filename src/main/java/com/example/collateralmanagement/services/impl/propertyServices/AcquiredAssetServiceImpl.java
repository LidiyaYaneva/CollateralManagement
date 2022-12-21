package com.example.collateralmanagement.services.impl.propertyServices;

import com.example.collateralmanagement.repositories.AcquiredAssetRepository;
import com.example.collateralmanagement.services.AcquiredAssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AcquiredAssetServiceImpl implements AcquiredAssetService {

    private final AcquiredAssetRepository acquiredAssetRepository;

    @Autowired
    public AcquiredAssetServiceImpl(AcquiredAssetRepository acquiredAssetRepository) {
        this.acquiredAssetRepository = acquiredAssetRepository;
    }
}
