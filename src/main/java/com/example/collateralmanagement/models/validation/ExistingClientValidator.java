package com.example.collateralmanagement.models.validation;

import com.example.collateralmanagement.repositories.BankClientRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class ExistingClientValidator implements ConstraintValidator<ExistingClient, String> {

    private final BankClientRepository bankClientRepository;

    @Autowired
    public ExistingClientValidator(BankClientRepository bankClientRepository) {
        this.bankClientRepository = bankClientRepository;
    }

    @Override
    public void initialize(ExistingClient constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return this.bankClientRepository.findByIdentificationNumber(value).isPresent();
    }
}
