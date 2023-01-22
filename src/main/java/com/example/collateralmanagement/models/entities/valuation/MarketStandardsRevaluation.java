package com.example.collateralmanagement.models.entities.valuation;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue(value = "MARKET_STANDARDS")
public class MarketStandardsRevaluation extends Evaluation {

    private static final String EVALUATION_TYPE = "MARKET_STANDARDS";

    private double multiplier;

    @ManyToOne
    @JoinColumn(name = "market_standards_per_year_id")
    private MarketStandardsPerYear marketStandardsPerYear;


    public MarketStandardsRevaluation(){
        super(EVALUATION_TYPE);
    }

    public double getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(double multiplier) {
        this.multiplier = multiplier;
    }
}
