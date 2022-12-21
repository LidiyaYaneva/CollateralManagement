package com.example.collateralmanagement.domain.entities.business;

import com.example.collateralmanagement.domain.entities.enums.ClientType;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table( name = "clients")
public class BankClient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ClientType clientType;

    @Column(name = "identification_number", nullable = false, unique = true)
    private String identificationNumber;

    @Column
    private String contacts;

    @OneToMany(mappedBy = "client", targetEntity = Loan.class, fetch = FetchType.LAZY)
    private Set<Loan> loans;

    public BankClient(String name, ClientType clientType, String identificationNumber, String contacts){
        this.name = name;
        this.clientType = clientType;
        this.identificationNumber= identificationNumber;
        this.contacts= contacts;
        this.loans = new HashSet<>();
    }

    public BankClient() {}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public Set<Loan> getLoans() {
        return loans;
    }

    public void setLoans(Set<Loan> loans) {
        this.loans = loans;
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
}
