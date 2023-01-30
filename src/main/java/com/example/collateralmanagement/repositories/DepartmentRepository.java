package com.example.collateralmanagement.repositories;

import com.example.collateralmanagement.models.entities.business.Department;
import com.example.collateralmanagement.models.enums.DepartmentEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Optional<Department> findByName(DepartmentEnum accountableDepartment);

}
