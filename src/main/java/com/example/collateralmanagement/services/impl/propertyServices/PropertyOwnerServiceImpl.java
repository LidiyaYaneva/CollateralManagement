package com.example.collateralmanagement.services.impl.propertyServices;

import com.example.collateralmanagement.repositories.PropertyOwnerRecordRepository;
import com.example.collateralmanagement.services.OwnershipHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyOwnerServiceImpl implements OwnershipHistoryService {

    private final PropertyOwnerRecordRepository propertyOwnerRecordRepository;
    @Autowired
    public PropertyOwnerServiceImpl(PropertyOwnerRecordRepository propertyOwnerRecordRepository) {
        this.propertyOwnerRecordRepository = propertyOwnerRecordRepository;
    }


}
