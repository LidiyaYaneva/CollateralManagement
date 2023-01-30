package com.example.collateralmanagement.models.dtos.asset;

import com.example.collateralmanagement.models.enums.CollateralCategory;


public class CollateralTypeDTO {

    private CollateralCategory type;

    private double multiplier;

    private String description;

    public CollateralTypeDTO() {
    }

    public CollateralTypeDTO(String type, double multiplier, String description) {
        this.type = CollateralCategory.valueOf(type);
        this.multiplier = multiplier;
        this.description = description;
    }

    public CollateralCategory getType() {
        return type;
    }

    public void setType(CollateralCategory type) {
        this.type = type;
    }

    public double getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(double multiplier) {
        this.multiplier = multiplier;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
