package com.example.collateralmanagement.models.dtos.asset;


import java.time.LocalDate;

public class AddAcquiredAssetDTO {

    private Long assetId;

    private String acquisitionDate;

    private String saleDate;

    private String managementStrategy;

    private boolean isActive;

    public AddAcquiredAssetDTO() {
    }

    public AddAcquiredAssetDTO(Long assetId, String acquisitionDate, String saleDate, String managementStrategy, boolean isActive) {
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

    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String saleDate) {
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
