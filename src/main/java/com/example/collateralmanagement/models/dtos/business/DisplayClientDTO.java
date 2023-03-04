package com.example.collateralmanagement.models.dtos.business;

import com.example.collateralmanagement.models.enums.ClientType;

public class DisplayClientDTO {

    private String identificationNumber;

    private String name;

    private ClientType clientType;

    public DisplayClientDTO() {
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public DisplayClientDTO setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
        return this;
    }

    public String getName() {
        return name;
    }

    public DisplayClientDTO setName(String name) {
        this.name = name;
        return this;
    }

    public ClientType getClientType() {
        return clientType;
    }

    public DisplayClientDTO setClientType(ClientType clientType) {
        this.clientType = clientType;
        return this;
    }
}
