package com.example.collateralmanagement.repositories;

import com.example.collateralmanagement.domain.entities.property.PropertyItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyItemRepository extends JpaRepository<PropertyItem, Long> {

}
