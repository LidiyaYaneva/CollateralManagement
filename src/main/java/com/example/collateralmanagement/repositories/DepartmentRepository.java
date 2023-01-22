package com.example.collateralmanagement.repositories;

import com.example.collateralmanagement.models.entities.business.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
