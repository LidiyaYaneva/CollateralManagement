package com.example.collateralmanagement.models.entities.valuation;

import com.example.collateralmanagement.models.entities.asset.Asset;
import com.example.collateralmanagement.models.enums.EvaluationType;
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
    @JoinColumn(name = "asset_id", referencedColumnName = "id")
    protected Asset asset;

    @Column(nullable = false)
    protected LocalDate date;

    @Column (nullable = false, insertable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    protected EvaluationType type;

    @Column(nullable = false)
    protected Double result;

    public Evaluation(){}

    public Evaluation(String type){
        this.type = EvaluationType.valueOf(type);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public EvaluationType getType() {
        return type;
    }

    public void setType(EvaluationType evaluationType) {
        this.type = evaluationType;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }
}
