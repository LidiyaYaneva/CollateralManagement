package com.example.collateralmanagement.repositories;

import com.example.collateralmanagement.models.entities.business.BankClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankClientRepository extends JpaRepository<BankClient, Long> {

    Optional<BankClient> findByIdentificationNumber(String identificationNumber);
}


