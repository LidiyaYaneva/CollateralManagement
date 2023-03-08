package com.example.collateralmanagement.models.entities.asset;

import com.example.collateralmanagement.models.entities.business.Loan;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "collaterals")
public class Collateral {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name= "asset_id",referencedColumnName = "id")
    private Asset asset;

    @Column(name = "date_of_link_to_loans", nullable = false)
    private LocalDate dateOfLinkToLoan;

    @Column (name = "initial_collateral_value", nullable = false)
    private Double initialCollateralValue;

    @ManyToMany(mappedBy = "collaterals", targetEntity = Loan.class)
    private Set<Loan> loans;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collateral() {
        this.loans = new HashSet<Loan>();
    }

    public Collateral(Asset asset, LocalDate date) {
        this();
        this.asset = asset;
        this.dateOfLinkToLoan = date;
    }

    public Set<Loan> getLoans() {
        return loans;
    }

    public void setLoans(Set<Loan> loans) {
        this.loans = loans;
    }

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    public LocalDate getDateOfLinkToLoan() {
        return dateOfLinkToLoan;
    }

    public void setDateOfLinkToLoan(LocalDate dateOfLinkToLoan) {
        this.dateOfLinkToLoan = dateOfLinkToLoan;
    }

    public Double getInitialCollateralValue() {
        return initialCollateralValue;
    }

    public void setInitialCollateralValue(Double initialCollateralValue) {
        this.initialCollateralValue = initialCollateralValue;
    }
}
