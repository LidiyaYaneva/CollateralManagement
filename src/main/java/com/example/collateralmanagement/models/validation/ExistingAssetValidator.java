package com.example.collateralmanagement.models.validation;

import com.example.collateralmanagement.repositories.AssetRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ExistingAssetValidator implements ConstraintValidator<ExistingAsset, Long> {

    private final AssetRepository assetRepository;

    public ExistingAssetValidator(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    @Override
    public void initialize(ExistingAsset constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        return this.assetRepository.existsById(value);
    }
}
