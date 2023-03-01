package com.example.collateralmanagement.services.impl.businessServices;

import com.example.collateralmanagement.models.dtos.business.AddClientDTO;
import com.example.collateralmanagement.models.dtos.business.DisplayClientDTO;
import com.example.collateralmanagement.models.dtos.business.SearchClientDTO;
import com.example.collateralmanagement.models.entities.business.BankClient;
import com.example.collateralmanagement.models.entities.business.Loan;
import com.example.collateralmanagement.repositories.BankClientRepository;
import com.example.collateralmanagement.repositories.LoanRepository;
import com.example.collateralmanagement.services.BankClientService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class BankClientServiceImpl implements BankClientService {

    private final BankClientRepository bankClientRepository;

    private final LoanRepository loanRepository;

    private final Logger LOGGER = LoggerFactory.getLogger(BankClientServiceImpl.class);
    private final ModelMapper modelMapper;

    @Autowired
    public BankClientServiceImpl(BankClientRepository bankClientRepository, LoanRepository loanRepository, ModelMapper modelMapper) {
        this.bankClientRepository = bankClientRepository;
        this.loanRepository = loanRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addClient(AddClientDTO addClientDTO) {

        String identificationNumber = addClientDTO.getIdentificationNumber();
        Optional<BankClient> optClient = this.bankClientRepository
               .findByIdentificationNumber(identificationNumber);
        if (optClient.isPresent()){
           LOGGER.info("Client with identificationNumber [{}] already exists",identificationNumber);
        }
        else {
            BankClient bankClient = this.modelMapper.map(addClientDTO, BankClient.class);
            this.bankClientRepository.save(bankClient);
        }

    }

    @Override
    @Transactional
    public boolean deleteClient(String identificationNumber) {

        Optional<BankClient> optClient = this.bankClientRepository
                .findByIdentificationNumber(identificationNumber);
        if (optClient.isEmpty()){
            LOGGER.info("Client with number [{}] not found", identificationNumber);
            return false;
        }
        else {
            Long clientId = optClient.get().getId();
            Set<Loan> loans = this.loanRepository.findAllByClientId(clientId);
            loans.forEach(l -> l.setClient(null));
            this.bankClientRepository.delete(optClient.get());
            return true;
        }
    }

    @Override
    public List<DisplayClientDTO> findClient(SearchClientDTO searchClientDTO) {
        return null;
    }
}

