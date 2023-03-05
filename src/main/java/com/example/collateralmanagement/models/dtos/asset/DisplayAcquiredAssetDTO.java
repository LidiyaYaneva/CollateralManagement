package com.example.collateralmanagement.models.dtos.asset;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

public class DisplayAcquiredAssetDTO {

    private Long id;

    private Long assetId;
    private String description;

    private String keyword;

    private Double marketValue;

    private LocalDate acquisitionDate;

    private String managementStrategy;

    public DisplayAcquiredAssetDTO() {
    }

    public DisplayAcquiredAssetDTO(Long id, Long assetId, String description, String keyword, LocalDate acquisitionDate, String managementStrategy) {
        this.id = id;
        this.assetId = assetId;
        this.description = description;
        this.keyword = keyword;
        this.acquisitionDate = acquisitionDate;
        this.managementStrategy = managementStrategy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }


    public LocalDate getAcquisitionDate() {
        return acquisitionDate;
    }

    public void setAcquisitionDate(LocalDate acquisitionDate) {
        this.acquisitionDate = acquisitionDate;
    }


    public String getManagementStrategy() {
        return managementStrategy;
    }

    public void setManagementStrategy(String managementStrategy) {
        this.managementStrategy = managementStrategy;
    }

    public Long getAssetId() {
        return assetId;
    }

    public void setAssetId(Long assetId) {
        this.assetId = assetId;
    }

    public Double getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(Double marketValue) {
        this.marketValue = marketValue;
    }
}
