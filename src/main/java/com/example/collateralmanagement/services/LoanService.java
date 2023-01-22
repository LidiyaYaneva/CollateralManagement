package com.example.collateralmanagement.services;

import com.example.collateralmanagement.models.dtos.business.ImportLoanDTO;

public interface LoanService {

    String addLoan (ImportLoanDTO importLoanDTO);
}
