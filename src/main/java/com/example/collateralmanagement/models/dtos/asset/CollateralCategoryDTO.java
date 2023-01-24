package com.example.collateralmanagement.models.dtos.asset;

import com.example.collateralmanagement.models.entities.enums.CollateralCategory;


public class CollateralCategoryDTO {

    private CollateralCategory type;

    private double multiplier;

    private String description;

    public CollateralCategoryDTO() {
    }

    public CollateralCategoryDTO(CollateralCategory type, double multiplier, String description) {
        this.type = type;
        this.multiplier = multiplier;
        this.description = description;
    }

}
