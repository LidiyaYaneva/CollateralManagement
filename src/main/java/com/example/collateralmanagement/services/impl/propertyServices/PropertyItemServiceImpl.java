package com.example.collateralmanagement.services.impl.propertyServices;

import com.example.collateralmanagement.repositories.PropertyItemRepository;
import com.example.collateralmanagement.services.PropertyItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyItemServiceImpl implements PropertyItemService {

    private final PropertyItemRepository propertyItemRepository;

    @Autowired
    public PropertyItemServiceImpl(PropertyItemRepository propertyItemRepository) {
        this.propertyItemRepository = propertyItemRepository;
    }


}
