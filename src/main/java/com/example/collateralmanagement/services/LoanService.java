package com.example.collateralmanagement.services;

import com.example.collateralmanagement.domain.dtos.business.ImportLoanDTO;

public interface LoanService {

    String addLoan (ImportLoanDTO importLoanDTO);
}
