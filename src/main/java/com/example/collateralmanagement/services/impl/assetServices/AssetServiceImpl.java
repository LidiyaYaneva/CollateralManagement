package com.example.collateralmanagement.services.impl.assetServices;

import com.example.collateralmanagement.models.dtos.asset.CreateAssetDTO;
import com.example.collateralmanagement.models.entities.business.Department;
import com.example.collateralmanagement.models.entities.enums.DepartmentEnum;
import com.example.collateralmanagement.models.entities.asset.Asset;
import com.example.collateralmanagement.repositories.DepartmentRepository;
import com.example.collateralmanagement.repositories.AssetRepository;
import com.example.collateralmanagement.services.AssetService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AssetServiceImpl implements AssetService {

    private final AssetRepository propertyItemRepository;
    private final DepartmentRepository departmentRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public AssetServiceImpl(AssetRepository propertyItemRepository, DepartmentRepository departmentRepository, ModelMapper modelMapper) {
        this.propertyItemRepository = propertyItemRepository;
        this.departmentRepository = departmentRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public String createAsset(CreateAssetDTO createAssetDTO) {
        String departmentName = createAssetDTO.getAccountableDepartment();
        DepartmentEnum departmentEnum = DepartmentEnum.valueOf(departmentName.toUpperCase().trim());

        Optional<Department> optDepartment = this.departmentRepository
                .findByName(departmentEnum);
        if (optDepartment.isEmpty())
            return "Invalid department";
        else {
            Asset propertyItem = this.modelMapper.map(createAssetDTO, Asset.class);
            optDepartment.ifPresent(propertyItem::setCurrentAccountableDepartment);
            this.propertyItemRepository.save(propertyItem);
            return "Property item created successfully!";

        }
    }
}
