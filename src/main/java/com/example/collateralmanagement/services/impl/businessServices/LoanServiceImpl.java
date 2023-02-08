package com.example.collateralmanagement.services.impl.businessServices;

import com.example.collateralmanagement.models.dtos.business.AddLoanDTO;
import com.example.collateralmanagement.models.entities.asset.Collateral;
import com.example.collateralmanagement.models.entities.business.BankClient;
import com.example.collateralmanagement.models.entities.business.Loan;
import com.example.collateralmanagement.repositories.BankClientRepository;
import com.example.collateralmanagement.repositories.CollateralRepository;
import com.example.collateralmanagement.repositories.LoanRepository;
import com.example.collateralmanagement.services.LoanService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;

    private final CollateralRepository collateralRepository;

    private final Logger LOGGER = LoggerFactory.getLogger(BankClientServiceImpl.class);

    private final BankClientRepository bankClientRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public LoanServiceImpl(LoanRepository loanRepository, CollateralRepository collateralRepository, BankClientRepository bankClientRepository, ModelMapper modelMapper) {
        this.loanRepository = loanRepository;
        this.collateralRepository = collateralRepository;
        this.bankClientRepository = bankClientRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addLoan(AddLoanDTO addLoanDTO) {

        String clientIdNumber = addLoanDTO.getClientBulstatOrEGN();
        Optional<BankClient> optClient = this.bankClientRepository
                .findByIdentificationNumber(clientIdNumber);

        if (optClient.isEmpty())
            LOGGER.info("Client with identificationNumber [{}] not found", clientIdNumber);
        else {
            String loanNumber = addLoanDTO.getLoanNumber();
            Optional<Loan> optLoan = this.loanRepository.findByLoanNumber(loanNumber);

            if (optLoan.isPresent()) {
                LOGGER.info("Loan with number [{}] already exists",loanNumber);
            }
            else {
                Loan loan = this.modelMapper.map(addLoanDTO, Loan.class);
                optClient.ifPresent(loan::setClient);
                this.loanRepository.save(loan);
            }
        }
    }

    @Override
    public boolean deleteLoan(String loanNumber) {

        Optional<Loan> optLoan = this.loanRepository.findByLoanNumber(loanNumber);

        if (optLoan.isEmpty()){
            LOGGER.info("Loan with number [{}] not found", loanNumber);
            return false;
        }
        else {
            Long loanId = optLoan.get().getId();
            Set<Collateral> collaterals = this.collateralRepository.findAllByLoanId(loanId);
            collaterals.forEach(c-> c.setLoans(null));
            this.loanRepository.delete(optLoan.get());
            return true;
        }
    }
}
