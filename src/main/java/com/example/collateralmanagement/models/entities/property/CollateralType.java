package com.example.collateralmanagement.models.entities.property;

import com.example.collateralmanagement.models.entities.enums.CollateralCategory;
import jakarta.persistence.*;

@Entity
@Table(name = "collateral_types")
public class CollateralType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CollateralCategory type;

    @Column(nullable = false)
    private double multiplier;

    @Column
    private String description;

    public CollateralType(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
