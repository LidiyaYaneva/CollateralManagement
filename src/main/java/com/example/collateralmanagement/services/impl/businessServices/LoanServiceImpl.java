package com.example.collateralmanagement.services.impl.businessServices;

import com.example.collateralmanagement.domain.dtos.business.ImportLoanDTO;
import com.example.collateralmanagement.domain.entities.business.BankClient;
import com.example.collateralmanagement.domain.entities.business.Loan;
import com.example.collateralmanagement.repositories.BankClientRepository;
import com.example.collateralmanagement.repositories.LoanRepository;
import com.example.collateralmanagement.services.LoanService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;

    private final BankClientRepository bankClientRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public LoanServiceImpl(LoanRepository loanRepository, BankClientRepository bankClientRepository, ModelMapper modelMapper) {
        this.loanRepository = loanRepository;
        this.bankClientRepository = bankClientRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public String addLoan(ImportLoanDTO importLoanDTO) {

        String loanNumber = importLoanDTO.getLoanNumber();
        Optional<Loan> optLoan = this.loanRepository.findByLoanNumber(loanNumber);

        Long clientId = importLoanDTO.getClientId();
        Optional<BankClient> optClient = this.bankClientRepository.findById(clientId);

        if(optClient.isEmpty())
            //kjhohpi

        if (optLoan.isEmpty()){

            Loan loan = this.modelMapper.map(importLoanDTO, Loan.class);
            optClient.ifPresent(loan::setClient);
            this.loanRepository.save(loan);
            return "Successfully added loan";
        }
        return "Loan already exists!";
    }
}
