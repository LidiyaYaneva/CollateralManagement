package com.example.collateralmanagement.services;

import com.example.collateralmanagement.models.dtos.asset.CollateralTypeDTO;

import java.io.IOException;
import java.util.List;

public interface CollateralTypeService {

    boolean isEmpty();

    String readCollateralTypesFormFile () throws IOException;

    void seedCollateralTypes() throws IOException;

   // void updateCollateralTypesMultipliers();

    //void updateCollateralTypesDescription();

    List<CollateralTypeDTO> getCollateralTypesInfo();

}
