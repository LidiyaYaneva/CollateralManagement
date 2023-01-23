package com.example.collateralmanagement.services.impl.propertyServices;

import com.example.collateralmanagement.models.dtos.property.CreatePropertyItemDTO;
import com.example.collateralmanagement.models.entities.business.Department;
import com.example.collateralmanagement.models.entities.enums.DepartmentEnum;
import com.example.collateralmanagement.models.entities.property.PropertyItem;
import com.example.collateralmanagement.repositories.DepartmentRepository;
import com.example.collateralmanagement.repositories.PropertyItemRepository;
import com.example.collateralmanagement.services.PropertyItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PropertyItemServiceImpl implements PropertyItemService {

    private final PropertyItemRepository propertyItemRepository;
    private final DepartmentRepository departmentRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public PropertyItemServiceImpl(PropertyItemRepository propertyItemRepository, DepartmentRepository departmentRepository, ModelMapper modelMapper) {
        this.propertyItemRepository = propertyItemRepository;
        this.departmentRepository = departmentRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public String createPropertyItem(CreatePropertyItemDTO createPropertyItemDTO) {
        String departmentName = createPropertyItemDTO.getAccountableDepartment();
        DepartmentEnum departmentEnum = DepartmentEnum.valueOf(departmentName.toUpperCase().trim());

        Optional<Department> optDepartment = this.departmentRepository
                .findByName(departmentEnum);
        if (optDepartment.isEmpty())
            return "Invalid department";
        else {
            PropertyItem propertyItem = this.modelMapper.map(createPropertyItemDTO, PropertyItem.class);
            optDepartment.ifPresent(propertyItem::setCurrentAccountableDepartment);
            this.propertyItemRepository.save(propertyItem);
            return "Property item created successfully!";

        }
    }
}
