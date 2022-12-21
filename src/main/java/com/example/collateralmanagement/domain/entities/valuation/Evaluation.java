package com.example.collateralmanagement.domain.entities.valuation;

import com.example.collateralmanagement.domain.entities.property.PropertyItem;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "evaluations")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public class Evaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    protected Long id;

    @ManyToOne
    @JoinColumn(name = "property_item_id", referencedColumnName = "id")
    protected PropertyItem propertyItem;

    @Column(nullable = false)
    protected LocalDate date;

    @Column (nullable = false, insertable = false, updatable = false)
    protected String type;

    @Column(nullable = false)
    protected Double result;

    public Evaluation(){}

    public Evaluation(String type){
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PropertyItem getPropertyItem() {
        return propertyItem;
    }

    public void setPropertyItem(PropertyItem propertyItem) {
        this.propertyItem = propertyItem;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String evaluationType) {
        this.type = evaluationType;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }
}
