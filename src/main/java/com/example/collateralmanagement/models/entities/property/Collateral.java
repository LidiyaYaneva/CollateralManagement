package com.example.collateralmanagement.models.entities.property;

import com.example.collateralmanagement.models.entities.business.Loan;
import jakarta.persistence.*;

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
    @JoinColumn(name = "property_item_id", referencedColumnName = "id")
    private PropertyItem propertyItem;

    @ManyToOne
    @JoinColumn(name = "collateral_type_id",referencedColumnName = "id")
    private CollateralType type;


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

    public CollateralType getType() {
        return type;
    }

    public void setType(CollateralType type) {
        this.type = type;
    }


    public Set<Loan> getLoans() {
        return loans;
    }

    public void setLoans(Set<Loan> loans) {
        this.loans = loans;
    }

    public PropertyItem getPropertyItem() {
        return propertyItem;
    }

    public void setPropertyItem(PropertyItem propertyItem) {
        this.propertyItem = propertyItem;
    }
}
