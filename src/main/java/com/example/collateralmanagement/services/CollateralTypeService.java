package com.example.collateralmanagement.services;

import com.example.collateralmanagement.models.dtos.asset.CollateralTypeDTO;
import com.example.collateralmanagement.models.entities.asset.CollateralType;
import com.example.collateralmanagement.models.enums.CollateralCategory;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface CollateralTypeService {

    boolean isEmpty();

    String readCollateralTypesFormFile () throws IOException;

    void seedCollateralTypes() throws IOException;

   // void updateCollateralTypesMultipliers();

    //void updateCollateralTypesDescription();

    List<CollateralTypeDTO> getCollateralTypesInfo();

    Optional<CollateralType> getCollateralType(CollateralCategory collateralCategory);
}
