package com.example.collateralmanagement.models.dtos.business;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class BulstatEGNDTO {

    @NotBlank
    @Size(min = 2, max = 20)
    private String identificationNumber;

    public BulstatEGNDTO() {
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }


}
