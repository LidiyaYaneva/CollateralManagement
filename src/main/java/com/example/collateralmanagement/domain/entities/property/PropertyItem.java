package com.example.collateralmanagement.domain.entities.property;

import com.example.collateralmanagement.domain.entities.business.Department;
import com.example.collateralmanagement.domain.entities.valuation.Evaluation;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "property_items")
public class PropertyItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    protected Long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    protected String description;

    @OneToMany(mappedBy = "propertyItem", targetEntity = PropertyOwnerRecord.class)
    protected Set<PropertyOwnerRecord> ownershipHistory;

    @OneToMany (mappedBy = "propertyItem", targetEntity = Evaluation.class)
    protected Set<Evaluation> evaluations;

    @ManyToOne
    @JoinColumn(name = "current_accountable_department")
    protected Department currentAccountableDepartment;

    public PropertyItem(){
        this.evaluations= new HashSet<Evaluation>();
    }

    public PropertyItem(Department currentAccountableDepartment) {
        this();
        this.currentAccountableDepartment= currentAccountableDepartment;
    }

    public PropertyItem(String description, Department currentAccountableDepartment){
        this(currentAccountableDepartment);
        this.description = description;
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

    public Department getCurrentAccountableDepartment() {
        return currentAccountableDepartment;
    }

    public void setCurrentAccountableDepartment(Department currentAccountableDepartment) {
        this.currentAccountableDepartment = currentAccountableDepartment;
    }

    public Set<Evaluation> getEvaluations() {
        return evaluations;
    }

    public void setEvaluations(Set<Evaluation> evaluations) {
        this.evaluations = evaluations;
    }

    public Set<PropertyOwnerRecord> getOwnershipHistory() {
        return ownershipHistory;
    }

    public void setOwnershipHistory(Set<PropertyOwnerRecord> ownershipHistory) {
        this.ownershipHistory = ownershipHistory;
    }
}
