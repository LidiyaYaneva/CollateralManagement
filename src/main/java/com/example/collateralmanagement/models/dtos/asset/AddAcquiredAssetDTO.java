package com.example.collateralmanagement.models.dtos.asset;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;
import java.util.Optional;

public class AddAcquiredAssetDTO {
    @NotBlank
    private Long assetId;
    @NotBlank
    private String acquisitionDate;

    private Optional<String> saleDate;

    private String managementStrategy;
    @NotBlank
    private boolean isActive;

    public AddAcquiredAssetDTO() {
    }

    public AddAcquiredAssetDTO(Long assetId, String acquisitionDate, Optional<String> saleDate, String managementStrategy, boolean isActive) {
        this.assetId = assetId;
        this.acquisitionDate = acquisitionDate;
        this.saleDate = saleDate;
        this.managementStrategy = managementStrategy;
        this.isActive = isActive;
    }

    public Long getAssetId() {
        return assetId;
    }

    public void setAssetId(Long assetId) {
        this.assetId = assetId;
    }

    public String getAcquisitionDate() {
        return acquisitionDate;
    }

    public void setAcquisitionDate(String acquisitionDate) {
        this.acquisitionDate = acquisitionDate;
    }

    public Optional<String> getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Optional<String> saleDate) {
        this.saleDate = saleDate;
    }

    public String getManagementStrategy() {
        return managementStrategy;
    }

    public void setManagementStrategy(String managementStrategy) {
        this.managementStrategy = managementStrategy;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
