package com.example.collateralmanagement.services;


import com.example.collateralmanagement.models.dtos.business.AddClientDTO;
import com.example.collateralmanagement.models.dtos.business.DisplayClientDTO;
import com.example.collateralmanagement.models.dtos.business.SearchClientDTO;

import java.util.List;

public interface BankClientService {

    void addClient (AddClientDTO addClientDTO);

    boolean deleteClient (String identificationNumber);

    List<DisplayClientDTO> findClient(SearchClientDTO searchClientDTO);
}
