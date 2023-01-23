package com.example.collateralmanagement.services.impl.businessServices;

import com.example.collateralmanagement.models.dtos.business.AddClientDTO;
import com.example.collateralmanagement.models.entities.business.BankClient;
import com.example.collateralmanagement.repositories.BankClientRepository;
import com.example.collateralmanagement.services.BankClientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BankClientServiceImpl implements BankClientService {

    private final BankClientRepository bankClientRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public BankClientServiceImpl(BankClientRepository bankClientRepository, ModelMapper modelMapper) {
        this.bankClientRepository = bankClientRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public String addClient(AddClientDTO addClientDTO) {

        String identificationNumber = addClientDTO.getIdentificationNumber();
        Optional<BankClient> optClient = this.bankClientRepository
               .findByIdentificationNumber(identificationNumber);

        if (optClient.isEmpty()){
            BankClient bankClient = this.modelMapper.map(addClientDTO, BankClient.class);
            this.bankClientRepository.save(bankClient);
            return "Successfully added client";
        }
        return "Client already exists!";

    }
}
