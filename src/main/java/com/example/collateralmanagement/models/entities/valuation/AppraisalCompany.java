package com.example.collateralmanagement.models.entities.valuation;

import jakarta.persistence.*;

@Entity
@Table( name = "appraisal_companies")
public class AppraisalCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String companyBULSTAT;

    public AppraisalCompany(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyBULSTAT() {
        return companyBULSTAT;
    }

    public void setCompanyBULSTAT(String companyBULSTAT) {
        this.companyBULSTAT = companyBULSTAT;
    }
}
