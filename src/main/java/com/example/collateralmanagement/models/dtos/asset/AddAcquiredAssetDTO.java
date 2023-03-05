package com.example.collateralmanagement.models.dtos.asset;


import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.Optional;

public class AddAcquiredAssetDTO {
    @NotNull
    @Positive
    private Long assetId;
    @NotNull
    @PastOrPresent
    private LocalDate acquisitionDate;

    private Optional<LocalDate> saleDate;

    @NotBlank
    @Size(min= 2)
    private String managementStrategy;

    private Boolean active;

    public AddAcquiredAssetDTO() {
    }

    public AddAcquiredAssetDTO(Long assetId, LocalDate acquisitionDate, Optional<LocalDate> saleDate, String managementStrategy, boolean isActive) {
        this.assetId = assetId;
        this.acquisitionDate = acquisitionDate;
        this.saleDate = saleDate;
        this.managementStrategy = managementStrategy;
        this.active = isActive;
    }

    public Long getAssetId() {
        return assetId;
    }

    public void setAssetId(Long assetId) {
        this.assetId = assetId;
    }

    public LocalDate getAcquisitionDate() {
        return acquisitionDate;
    }

    public void setAcquisitionDate(LocalDate acquisitionDate) {
        this.acquisitionDate = acquisitionDate;
    }

    public Optional<LocalDate> getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Optional<LocalDate> saleDate) {
        this.saleDate = saleDate;
    }

    public String getManagementStrategy() {
        return managementStrategy;
    }

    public void setManagementStrategy(String managementStrategy) {
        this.managementStrategy = managementStrategy;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
