package com.example.collateralmanagement.models.entities.asset;

import com.example.collateralmanagement.models.entities.business.Department;
import com.example.collateralmanagement.models.entities.valuation.Evaluation;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "assets")
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    protected Long id;

    @ManyToOne
    @JoinColumn(name = "collateral_type", referencedColumnName = "id")
    protected CollateralType collateralType;

    @Column(nullable = false, columnDefinition = "TEXT")
    protected String description;

    @Column(name = "description_keyword", nullable = false)
    protected String keyword;

   @Column(nullable = false)
   protected String owner;

    @Column(name = "ownership_document", nullable = true)
    protected String ownershipDocument;

    @OneToMany (mappedBy = "asset", targetEntity = Evaluation.class)
    protected Set<Evaluation> evaluations;

    @ManyToOne
    @JoinColumn(name = "current_accountable_department", referencedColumnName = "id", nullable = true)
    protected Department currentAccountableDepartment;

    public Asset(){
        this.evaluations= new HashSet<Evaluation>();
    }



    public Asset(Department currentAccountableDepartment) {
        this();
        this.currentAccountableDepartment= currentAccountableDepartment;
    }

    public Asset(CollateralType collateralType,String description, String keyword, Department currentAccountableDepartment){
        this(currentAccountableDepartment);
        this.collateralType = collateralType;
        this.description = description;
        this.keyword = keyword;
    }

    public Asset(CollateralType collateralType,String description, String keyword, String owner, String ownershipDocument, Department currentAccountableDepartment) {
        this(collateralType,description,keyword,currentAccountableDepartment);
        this.owner = owner;
        this.ownershipDocument = ownershipDocument;

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

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
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

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOwnershipDocument() {
        return ownershipDocument;
    }

    public void setOwnershipDocument(String ownershipDocument) {
        this.ownershipDocument = ownershipDocument;
    }

    public CollateralType getCollateralType() {
        return collateralType;
    }

    public void setCollateralType(CollateralType collateralType) {
        this.collateralType = collateralType;
    }
}
