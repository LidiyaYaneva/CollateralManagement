package com.example.collateralmanagement.services;


import com.example.collateralmanagement.domain.dtos.business.ImportClientDTO;

public interface BankClientService {

    String addClient (ImportClientDTO importClientDTO);

}
