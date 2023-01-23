package com.example.collateralmanagement.models.dtos.business;


import com.example.collateralmanagement.models.entities.enums.ClientType;

public class AddClientDTO {

    private String name;

    private ClientType clientType;

    private String identificationNumber;

    private String contacts;


    public AddClientDTO() {
    }

    public AddClientDTO(String name, String clientTypeText, String identificationNumber, String contacts){
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
