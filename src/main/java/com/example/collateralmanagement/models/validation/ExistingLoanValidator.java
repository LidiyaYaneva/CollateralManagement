package com.example.collateralmanagement.models.validation;

import com.example.collateralmanagement.repositories.LoanRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ExistingLoanValidator implements ConstraintValidator<ExistingLoan, String> {

    private final LoanRepository loanRepository;

    public ExistingLoanValidator(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @Override
    public void initialize(ExistingLoan constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return this.loanRepository.findByLoanNumber(value).isPresent();
    }
}
