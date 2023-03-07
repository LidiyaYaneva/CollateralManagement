package com.example.collateralmanagement.models.dtos.asset;

import com.example.collateralmanagement.models.enums.CollateralCategory;
import com.example.collateralmanagement.models.validation.ExistingAsset;
import com.example.collateralmanagement.models.validation.ExistingLoan;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class CreateCollateralDTO {

    @NotNull
    @Positive
    @ExistingAsset
    private Long assetId;

    @NotNull
    private CollateralCategory type;

    @NotBlank
    @Size(min = 2, max = 30)
    @ExistingLoan
    private String loanNumber;

    public CreateCollateralDTO() {
    }

    public Long getAssetId() {
        return assetId;
    }

    public void setAssetId(Long assetId) {
        this.assetId = assetId;
    }

    public String getLoanNumber() {
        return loanNumber;
    }

    public void setLoanNumber(String loanNumber) {
        this.loanNumber = loanNumber;
    }

    public CollateralCategory getType() {
        return type;
    }

    public void setType(CollateralCategory type) {
        this.type = type;
    }
}
