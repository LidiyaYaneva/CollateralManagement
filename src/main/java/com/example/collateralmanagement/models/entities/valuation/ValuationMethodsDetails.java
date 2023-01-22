package com.example.collateralmanagement.models.entities.valuation;

import jakarta.persistence.*;

@Entity
@Table(name = "valuation_methods_details")
public class ValuationMethodsDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne( mappedBy = "valuationMethodsDetails", targetEntity = Appraisal.class)
    private Appraisal appraisal;

    @Column(name ="market_approach_used",nullable = false)
    private boolean marketApproachUsed;

    @Column(name ="income_approach_used",nullable = false)
    private boolean incomeApproachUsed;

    @Column(name ="cost_approach_used",nullable = false)
    private boolean costApproachUsed;

    @Column(name ="other_approach_used",nullable = false)
    private boolean otherApproachUsed;

    @Column(name ="market_approach_value",nullable = true)
    private Double marketApproachValue;

    @Column(name ="income_approach_value",nullable = true)
    private Double incomeApproachValue;

    @Column(name ="cost_approach_value",nullable = true)
    private Double costApproachValue;

    @Column(name ="other_approach_value",nullable = true)
    private Double otherApproachValue;

    public ValuationMethodsDetails() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Appraisal getAppraisal() {
        return appraisal;
    }

    public void setAppraisal(Appraisal appraisal) {
        this.appraisal = appraisal;
    }

    public boolean isMarketApproachUsed() {
        return marketApproachUsed;
    }

    public void setMarketApproachUsed(boolean marketApproachUsed) {
        this.marketApproachUsed = marketApproachUsed;
    }

    public boolean isIncomeApproachUsed() {
        return incomeApproachUsed;
    }

    public void setIncomeApproachUsed(boolean incomeApproachUsed) {
        this.incomeApproachUsed = incomeApproachUsed;
    }

    public boolean isCostApproachUsed() {
        return costApproachUsed;
    }

    public void setCostApproachUsed(boolean costApproachUsed) {
        this.costApproachUsed = costApproachUsed;
    }

    public boolean isOtherApproachUsed() {
        return otherApproachUsed;
    }

    public void setOtherApproachUsed(boolean otherApproachUsed) {
        this.otherApproachUsed = otherApproachUsed;
    }

    public Double getMarketApproachValue() {
        return marketApproachValue;
    }

    public void setMarketApproachValue(Double marketApproachValue) {
        this.marketApproachValue = marketApproachValue;
    }

    public Double getIncomeApproachValue() {
        return incomeApproachValue;
    }

    public void setIncomeApproachValue(Double incomeApproachValue) {
        this.incomeApproachValue = incomeApproachValue;
    }

    public Double getCostApproachValue() {
        return costApproachValue;
    }

    public void setCostApproachValue(Double costApproachValue) {
        this.costApproachValue = costApproachValue;
    }

    public Double getOtherApproachValue() {
        return otherApproachValue;
    }

    public void setOtherApproachValue(Double otherApproachValue) {
        this.otherApproachValue = otherApproachValue;
    }
}
