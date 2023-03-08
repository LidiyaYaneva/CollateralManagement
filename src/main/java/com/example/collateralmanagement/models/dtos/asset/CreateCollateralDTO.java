package com.example.collateralmanagement.models.dtos.asset;

import com.example.collateralmanagement.models.enums.CollateralCategory;
import com.example.collateralmanagement.models.validation.ExistingAsset;
import com.example.collateralmanagement.models.validation.ExistingLoan;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class CreateCollateralDTO {

    @NotNull
    @Positive
    @ExistingAsset
    private Long assetId;

    @NotNull
    @PastOrPresent
    private LocalDate dateOfLinkToLoan;

    @NotBlank
    @Size(min = 2, max = 30)
    @ExistingLoan
    private String loanNumber;

    @NotNull
    @Positive
    private Double initialCollateralValue;

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

    public LocalDate getDateOfLinkToLoan() {
        return dateOfLinkToLoan;
    }

    public void setDateOfLinkToLoan(LocalDate dateOfLinkToLoan) {
        this.dateOfLinkToLoan = dateOfLinkToLoan;
    }

    public Double getInitialCollateralValue() {
        return initialCollateralValue;
    }

    public void setInitialCollateralValue(Double initialCollateralValue) {
        this.initialCollateralValue = initialCollateralValue;
    }
}
