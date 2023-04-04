package com.example.collateralmanagement.services;

import com.example.collateralmanagement.models.entities.business.Department;
import com.example.collateralmanagement.models.enums.DepartmentEnum;
import jakarta.annotation.PostConstruct;

import java.util.Optional;

public interface DepartmentService {

    void seedDepartments ();

    boolean isEmpty ();

    //void updateDepartmentsIfEnumsAreAdded();

    @PostConstruct
    void init();

    boolean deleteDepartment(String name);

    Optional<Department> findByName(DepartmentEnum creditRisk);
}
