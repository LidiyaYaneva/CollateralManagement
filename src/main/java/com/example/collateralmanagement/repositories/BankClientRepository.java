package com.example.collateralmanagement.repositories;

import com.example.collateralmanagement.models.entities.business.BankClient;
import com.example.collateralmanagement.models.enums.ClientType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BankClientRepository extends JpaRepository<BankClient, Long> {

    Optional<BankClient> findByIdentificationNumber(String identificationNumber);

    List<BankClient> findAllByClientType (ClientType clientType);
}


