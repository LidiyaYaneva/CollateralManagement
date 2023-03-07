package com.example.collateralmanagement.services.impl.assetServices;

import com.example.collateralmanagement.models.dtos.asset.CreateCollateralDTO;
import com.example.collateralmanagement.models.dtos.asset.DisplayCollateralDTO;
import com.example.collateralmanagement.models.entities.asset.Collateral;
import com.example.collateralmanagement.repositories.CollateralRepository;
import com.example.collateralmanagement.services.CollateralService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollateralServiceImpl implements CollateralService {

    private final CollateralRepository collateralRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public CollateralServiceImpl(CollateralRepository collateralRepository, ModelMapper modelMapper) {
        this.collateralRepository = collateralRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addCollateral(CreateCollateralDTO createCollateralDTO) {

        Collateral collateralEntity = this.modelMapper.map(createCollateralDTO, Collateral.class);

        this.collateralRepository.save(collateralEntity);

    }

    @Override
    public boolean deleteCollateral(Long id) {
        return false;
    }

    @Override
    public List<DisplayCollateralDTO> findCollateralsOfRecentLoans() {
        return null;
    }
}
