package com.example.collateralmanagement.models.dtos.asset;

import com.example.collateralmanagement.models.enums.DepartmentEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class CreateAssetDTO {

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

    public CreateAssetDTO(String description, String keyword, String owner, String ownershipDocument, DepartmentEnum accountableDepartment) {
        this.description = description;
        this.keyword= keyword;
        this.owner = owner;
        this.ownershipDocument = ownershipDocument;
        this.accountableDepartment = accountableDepartment;
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
}
