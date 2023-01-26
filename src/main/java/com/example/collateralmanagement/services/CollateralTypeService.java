package com.example.collateralmanagement.services;

import com.example.collateralmanagement.models.dtos.asset.CollateralTypeDTO;
import com.example.collateralmanagement.models.entities.asset.CollateralType;

import java.io.IOException;

public interface CollateralTypeService {

    boolean isEmpty();

    String readCollateralTypesFormFile () throws IOException;

    void seedCollateralTypes() throws IOException;

    void updateCollateralTypesMultipliers();

    void updateCollateralTypesDescription();

    CollateralTypeDTO getCollateralTypesInfo();
}
