package com.example.collateralmanagement.services;

public interface DepartmentService {

    void seedDepartments ();

    boolean isEmpty ();

    void updateDepartmentsIfEnumsAreAdded();

    boolean deleteDepartment(String name);
}
