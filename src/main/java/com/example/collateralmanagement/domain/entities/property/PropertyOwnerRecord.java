package com.example.collateralmanagement.domain.entities.property;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "ownership_history")
public class PropertyOwnerRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column (nullable = false)
    private String owner;

    @Column(name = "ownership_start_date")
    private LocalDate ownershipStartDate;

    @Column(name = "ownership_document")
    private String ownershipDocument;

    @ManyToOne
    @JoinColumn(name = "property_item_id", referencedColumnName = "id")
    private PropertyItem propertyItem;


    public PropertyOwnerRecord() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public LocalDate getOwnershipStartDate() {
        return ownershipStartDate;
    }

    public void setOwnershipStartDate(LocalDate ownershipStartDate) {
        this.ownershipStartDate = ownershipStartDate;
    }

    public String getOwnershipDocument() {
        return ownershipDocument;
    }

    public PropertyItem getPropertyItem() {
        return propertyItem;
    }

    public void setPropertyItem(PropertyItem propertyItem) {
        this.propertyItem = propertyItem;
    }

    public void setOwnershipDocument(String ownershipDocument) {
        this.ownershipDocument = ownershipDocument;
    }
}
