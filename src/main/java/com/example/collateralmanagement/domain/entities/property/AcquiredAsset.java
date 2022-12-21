package com.example.collateralmanagement.domain.entities.property;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "acquired_assets")
public class AcquiredAsset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "property_item_id", referencedColumnName = "id")
    private PropertyItem propertyItem;

    @Column(nullable = false)
    private LocalDate acquisitionDate;

    @Column (nullable = true)
    private LocalDate saleDate;

    @Column(name = "management_strategy", columnDefinition = "TEXT")
    private String managementStrategy;

    @Column(nullable = false)
    private boolean isActive;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AcquiredAsset(){
    }

    public LocalDate getAcquisitionDate() {
        return acquisitionDate;
    }

    public void setAcquisitionDate(LocalDate acquisitionDate) {
        this.acquisitionDate = acquisitionDate;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDate saleDate) {
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

    public PropertyItem getPropertyItem() {
        return propertyItem;
    }

    public void setPropertyItem(PropertyItem propertyItem) {
        this.propertyItem = propertyItem;
    }
}
