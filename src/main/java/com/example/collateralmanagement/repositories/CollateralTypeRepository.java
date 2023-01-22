package com.example.collateralmanagement.repositories;

import com.example.collateralmanagement.models.entities.property.CollateralType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollateralTypeRepository extends JpaRepository<CollateralType, Long> {

}
