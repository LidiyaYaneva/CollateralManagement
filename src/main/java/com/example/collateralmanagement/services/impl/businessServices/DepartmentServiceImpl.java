package com.example.collateralmanagement.services.impl.businessServices;

import com.example.collateralmanagement.models.entities.asset.Asset;
import com.example.collateralmanagement.models.entities.business.Department;
import com.example.collateralmanagement.models.entities.authentication.UserEntity;
import com.example.collateralmanagement.models.enums.DepartmentEnum;
import com.example.collateralmanagement.repositories.AssetRepository;
import com.example.collateralmanagement.repositories.DepartmentRepository;
import com.example.collateralmanagement.repositories.UserRepository;
import com.example.collateralmanagement.services.DepartmentService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    private final UserRepository userRepository;

    private final AssetRepository assetRepository;

    private Logger LOGGER = LoggerFactory.getLogger(DepartmentServiceImpl.class);

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository, UserRepository userRepository, AssetRepository assetRepository) {
        this.departmentRepository = departmentRepository;
        this.userRepository = userRepository;
        this.assetRepository = assetRepository;
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

    @Override
    public void updateDepartmentsIfEnumsAreAdded() {

        List<DepartmentEnum> departmentEnums = Arrays.stream(DepartmentEnum.values()).toList();

        List<String> currentDepartmentsInDBAsStrings = this.departmentRepository.findAll()
                .stream().map(Department::getName).map(Enum::toString).toList();

        for (DepartmentEnum depEnum: departmentEnums) {
            if (!currentDepartmentsInDBAsStrings.contains(depEnum.toString())){
                Department department = new Department(depEnum);
                this.departmentRepository.save(department);
            }
        }

    }

    @Override
    @Transactional
    public boolean deleteDepartment(String name) {
        DepartmentEnum departmentEnum = DepartmentEnum.valueOf(name);

        Optional<Department> departmentOpt = this.departmentRepository.findByName(departmentEnum);

        if (departmentOpt.isEmpty()){
            LOGGER.info("Department [{}] not found", name);
            return false;
        }
        else {
            List<UserEntity> usersOfADepartment = this.userRepository.findAllByDepartmentName(departmentEnum);
            for (UserEntity user: usersOfADepartment) {
                user.setDepartment(null);
            }
            List<Asset> assets =this.assetRepository.findAllByCurrentAccountableDepartmentName(departmentEnum);
            for (Asset asset: assets) {
                asset.setCurrentAccountableDepartment(null);
            }
            this.departmentRepository.delete(departmentOpt.get());
            return true;
        }
    }
}
