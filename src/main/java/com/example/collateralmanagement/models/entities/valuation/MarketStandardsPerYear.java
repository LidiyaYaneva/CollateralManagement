package com.example.collateralmanagement.models.entities.valuation;

import jakarta.persistence.*;

@Entity
@Table(name = "market_standards_per_year")
public class MarketStandardsPerYear {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "provider_company",nullable = false)
    private String providerCompany;

    @Column(nullable = false)
    private int year;

    public MarketStandardsPerYear(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProviderCompany() {
        return providerCompany;
    }

    public void setProviderCompany(String providerCompany) {
        this.providerCompany = providerCompany;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
