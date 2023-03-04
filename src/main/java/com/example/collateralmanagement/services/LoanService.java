package com.example.collateralmanagement.services;

import com.example.collateralmanagement.models.dtos.business.AddLoanDTO;
import com.example.collateralmanagement.models.dtos.business.DisplayLoanDTO;
import com.example.collateralmanagement.models.dtos.business.SearchLoanDTO;

import java.util.List;

public interface LoanService {

    void addLoan (AddLoanDTO addLoanDTO);

    boolean deleteLoan (String loanNumber);

    List<DisplayLoanDTO> findLoans(SearchLoanDTO searchLoanDTO);

    List<DisplayLoanDTO> findAllActive();
}
