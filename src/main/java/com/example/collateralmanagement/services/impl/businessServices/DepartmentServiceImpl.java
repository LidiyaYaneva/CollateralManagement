package com.example.collateralmanagement.services.impl.businessServices;

import com.example.collateralmanagement.models.entities.business.Department;
import com.example.collateralmanagement.models.entities.enums.DepartmentEnum;
import com.example.collateralmanagement.repositories.DepartmentRepository;
import com.example.collateralmanagement.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }


    @Override
    public void seedDepartments() {

        DepartmentEnum[] departmentEnums = DepartmentEnum.values();
        List<Department> departments = new ArrayList<>();
        for (DepartmentEnum name: departmentEnums) {
            Department department = new Department(name);
            departments.add(department);
        }
        this.departmentRepository.saveAll(departments);

    }

    @Override
    public boolean isEmpty() {
        List<Department> departments = this.departmentRepository.findAll();
        return departments.isEmpty();
    }
}
