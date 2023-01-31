package com.example.collateralmanagement.services.impl.assetServices;

import com.example.collateralmanagement.models.dtos.asset.AddAcquiredAssetDTO;
import com.example.collateralmanagement.models.entities.asset.AcquiredAsset;
import com.example.collateralmanagement.models.entities.asset.Asset;
import com.example.collateralmanagement.models.entities.business.Department;
import com.example.collateralmanagement.models.enums.DepartmentEnum;
import com.example.collateralmanagement.repositories.AcquiredAssetRepository;
import com.example.collateralmanagement.repositories.AssetRepository;
import com.example.collateralmanagement.repositories.DepartmentRepository;
import com.example.collateralmanagement.services.AcquiredAssetService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AcquiredAssetServiceImpl implements AcquiredAssetService {

    private Logger LOGGER = LoggerFactory.getLogger(AcquiredAssetServiceImpl.class);
    private final AcquiredAssetRepository acquiredAssetRepository;
    private final AssetRepository assetRepository;

    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public AcquiredAssetServiceImpl(AcquiredAssetRepository acquiredAssetRepository, AssetRepository assetRepository,
                                    DepartmentRepository departmentRepository, ModelMapper modelMapper) {
        this.acquiredAssetRepository = acquiredAssetRepository;
        this.assetRepository = assetRepository;
        this.departmentRepository = departmentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addAcquiredAsset(AddAcquiredAssetDTO addAcquiredAssetDTO) {

        Optional<Asset> optAsset = this.assetRepository.findById(addAcquiredAssetDTO.getAssetId());
        if(optAsset.isEmpty()){
            LOGGER.info("Asset with id [{}] not found", addAcquiredAssetDTO.getAssetId());
        }
        else {

            AcquiredAsset acquiredAsset = this.modelMapper.map(addAcquiredAssetDTO, AcquiredAsset.class);
            acquiredAsset.setAsset(optAsset.get());
            this.acquiredAssetRepository.save(acquiredAsset);
            Optional<Department> department=this.departmentRepository.findByName(DepartmentEnum.PROPERTY_ADMINISTRATION);
            department.ifPresent(value -> optAsset.get().setCurrentAccountableDepartment(value));
            this.assetRepository.save(optAsset.get());
        }
    }
    @Override
    public boolean deleteAcquiredAsset(Long id) {

        Optional<AcquiredAsset> optionalAcquiredAsset = this.acquiredAssetRepository.findById(id);
        if (optionalAcquiredAsset.isEmpty()){
            LOGGER.info("AcquiredAsset with id [{}] not found ", id);
            return false;
        }
        else {
            this.acquiredAssetRepository.delete(optionalAcquiredAsset.get());
            return true;
        }
    }
}
