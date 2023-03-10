package com.example.collateralmanagement.services.impl.assetServices;

import com.example.collateralmanagement.models.dtos.asset.CreateAssetDTO;
import com.example.collateralmanagement.models.dtos.asset.DisplayAssetDTO;
import com.example.collateralmanagement.models.dtos.asset.SearchDTO;
import com.example.collateralmanagement.models.entities.asset.CollateralType;
import com.example.collateralmanagement.models.entities.business.Department;
import com.example.collateralmanagement.models.enums.DepartmentEnum;
import com.example.collateralmanagement.models.entities.asset.Asset;
import com.example.collateralmanagement.repositories.*;
import com.example.collateralmanagement.services.AssetService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class AssetServiceImpl implements AssetService {

    private final Logger LOGGER = LoggerFactory.getLogger(AssetServiceImpl.class);

    private final AssetRepository assetRepository;

    private final CollateralTypeRepository collateralTypeRepository;

    private final CollateralRepository collateralRepository;

    private final EvaluationRepository evaluationRepository;

    private final AcquiredAssetRepository acquiredAssetRepository;
    private final DepartmentRepository departmentRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public AssetServiceImpl(AssetRepository propertyItemRepository, CollateralTypeRepository collateralTypeRepository, CollateralRepository collateralRepository, EvaluationRepository evaluationRepository, AcquiredAssetRepository acquiredAssetRepository, DepartmentRepository departmentRepository, ModelMapper modelMapper) {
        this.assetRepository = propertyItemRepository;
        this.collateralTypeRepository = collateralTypeRepository;
        this.collateralRepository = collateralRepository;
        this.evaluationRepository = evaluationRepository;
        this.acquiredAssetRepository = acquiredAssetRepository;
        this.departmentRepository = departmentRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public void createAsset(CreateAssetDTO createAssetDTO) {

        Asset asset = this.modelMapper.map(createAssetDTO, Asset.class);

        DepartmentEnum departmentEnum = createAssetDTO.getAccountableDepartment();
        Optional<Department> optDepartment = this.departmentRepository
                .findByName(departmentEnum);

        if (departmentEnum == null || optDepartment.isEmpty()) {
            asset.setCurrentAccountableDepartment(null);
        } else {
            asset.setCurrentAccountableDepartment(optDepartment.get());
        }
        Optional<CollateralType> collateralType = this.collateralTypeRepository.findByType(createAssetDTO.getType());
        collateralType.ifPresent(asset::setCollateralType);
        this.assetRepository.save(asset);
    }

    @Override
    public List<DisplayAssetDTO> getAssetsOfClient(String bulstatOrEGN) {

        List<Asset> assets = this.assetRepository.findAllByClient(bulstatOrEGN);

        return Arrays.stream(this.modelMapper.map(assets, DisplayAssetDTO[].class)).toList();
    }

    @Override
    public List<DisplayAssetDTO> findAssetsByOwnerName(String owner) {

        List<Asset> assets = this.assetRepository.findAllByOwnerIgnoreCase(owner);

        return Arrays.stream(this.modelMapper.map(assets, DisplayAssetDTO[].class)).toList();
    }

//    @Override
//    @Transactional
//    public boolean deleteAssetAndSetRelationsToNULL(Long id) {
//
//        Asset asset = exists(id);
//        if (asset == null) {
//            return false;
//        } else {
//            List<AcquiredAsset> optAcquiredAssets = this.acquiredAssetRepository.findAllByAssetId(id);
//
//
//            List<Collateral> optCollaterals = this.collateralRepository.findAllByAssetId(id);
//
//
//            List<Evaluation> optAssetEvaluations = this.evaluationRepository.findAllByAssetId(id);
//
//
//        }
//        return true;
//    }

//    @Override
//    @Transactional
//    public boolean deleteAssetAndAllRelationEntities(Long id) {
//        return false;
//    }

    @Override
    public List<DisplayAssetDTO> findAssetsBySearchInput(SearchDTO searchDTO) {
        return null;
    }


    private Asset exists(Long id) {

        Optional<Asset> optAsset = this.assetRepository.findById(id);

        if (optAsset.isEmpty()) {
            LOGGER.info("Asset with id [{}] not found", id);
            return null;
        }

        return optAsset.get();
    }
}
