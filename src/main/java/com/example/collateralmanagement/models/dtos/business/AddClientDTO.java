package com.example.collateralmanagement.models.dtos.business;


import com.example.collateralmanagement.models.enums.ClientType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AddClientDTO {

    @NotBlank
    @Size(min = 2, max = 20)
    private String identificationNumber;
    @NotBlank
    @Size(min =2, max = 60)
    private String name;

    @NotNull
    private ClientType clientType;


    private String contacts;


    public AddClientDTO() {
    }

    public AddClientDTO(String name, ClientType clientType, String identificationNumber, String contacts) {
        this.name = name;
        this.clientType = clientType;
        this.identificationNumber = identificationNumber;
        this.contacts = contacts;
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
