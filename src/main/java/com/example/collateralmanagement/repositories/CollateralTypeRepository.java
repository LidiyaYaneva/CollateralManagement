package com.example.collateralmanagement.repositories;

import com.example.collateralmanagement.models.entities.asset.CollateralType;
import com.example.collateralmanagement.models.enums.CollateralCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CollateralTypeRepository extends JpaRepository<CollateralType, Long> {


    Optional<CollateralType> findByType(CollateralCategory collateralCategory);
}
