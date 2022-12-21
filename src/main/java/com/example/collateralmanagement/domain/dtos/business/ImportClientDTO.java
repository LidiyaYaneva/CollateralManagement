package com.example.collateralmanagement.domain.dtos.business;


import com.example.collateralmanagement.domain.entities.enums.ClientType;

public class ImportClientDTO {

    private String name;

    private ClientType clientType;

    private String identificationNumber;

    private String contacts;


    public ImportClientDTO() {
    }

    public ImportClientDTO(String name, String clientTypeText, String identificationNumber, String contacts){
        this.name = name;
        this.clientType = Enum.valueOf(ClientType.class, clientTypeText);
        this.identificationNumber = identificationNumber;
        this.contacts = contacts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ClientType getClientType() {
        return clientType;
    }

    public void setClientType(ClientType clientType) {
        this.clientType = clientType;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }
}
