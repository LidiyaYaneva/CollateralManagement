package com.example.collateralmanagement.models.dtos.asset;

import com.example.collateralmanagement.models.enums.CollateralCategory;
import com.example.collateralmanagement.models.enums.DepartmentEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateAssetDTO {

    @NotNull
    protected CollateralCategory type;

    @NotBlank
    @Size(min=5)
    protected String description;
    @NotBlank
    protected String keyword;

    @NotBlank
    protected String owner;
    protected String ownershipDocument;

    protected DepartmentEnum accountableDepartment;

    public CreateAssetDTO() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public DepartmentEnum getAccountableDepartment() {
        return accountableDepartment;
    }

    public void setAccountableDepartment(DepartmentEnum accountableDepartment) {
        this.accountableDepartment = accountableDepartment;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public CollateralCategory getType() {
        return type;
    }

    public void setType(CollateralCategory type) {
        this.type = type;
    }
}
