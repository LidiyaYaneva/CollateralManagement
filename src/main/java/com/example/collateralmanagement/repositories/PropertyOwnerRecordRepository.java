package com.example.collateralmanagement.repositories;

import com.example.collateralmanagement.domain.entities.property.PropertyOwnerRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyOwnerRecordRepository extends JpaRepository<PropertyOwnerRecord, Long> {

}
