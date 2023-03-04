package com.example.collateralmanagement.services;


import com.example.collateralmanagement.models.dtos.business.AddClientDTO;
import com.example.collateralmanagement.models.dtos.business.DisplayClientDTO;
import com.example.collateralmanagement.models.dtos.business.SearchClientDTO;
import com.example.collateralmanagement.models.enums.ClientType;

import java.util.List;

public interface BankClientService {

    void addClient (AddClientDTO addClientDTO);

    boolean deleteClient (String identificationNumber);

    List<DisplayClientDTO> findClient(SearchClientDTO searchClientDTO);

    List<DisplayClientDTO> findAllByClientType(ClientType clientType);

    List<DisplayClientDTO> findAll();
}
