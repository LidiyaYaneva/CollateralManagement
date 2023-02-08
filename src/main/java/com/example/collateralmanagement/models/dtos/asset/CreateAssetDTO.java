package com.example.collateralmanagement.models.dtos.asset;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public class CreateAssetDTO {
    @NotBlank
    protected String description;

    protected String keyword;

    protected String owner;

    protected String ownershipDocument;

    protected String accountableDepartment;

    public CreateAssetDTO() {
    }

    public CreateAssetDTO(String description, String keyword, String owner, String ownershipDocument, String accountableDepartment) {
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

    public String getAccountableDepartment() {
        return accountableDepartment;
    }

    public void setAccountableDepartment(String accountableDepartment) {
        this.accountableDepartment = accountableDepartment;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
