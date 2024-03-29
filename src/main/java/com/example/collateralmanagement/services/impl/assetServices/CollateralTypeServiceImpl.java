package com.example.collateralmanagement.services.impl.assetServices;

import com.example.collateralmanagement.models.dtos.asset.CollateralTypeDTO;
import com.example.collateralmanagement.models.entities.asset.CollateralType;
import com.example.collateralmanagement.models.enums.CollateralCategory;
import com.example.collateralmanagement.repositories.CollateralTypeRepository;
import com.example.collateralmanagement.services.CollateralTypeService;
import com.google.gson.Gson;
import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CollateralTypeServiceImpl implements CollateralTypeService {

    private final CollateralTypeRepository collateralTypeRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;

    @Autowired
    public CollateralTypeServiceImpl(CollateralTypeRepository collateralTypeRepository, Gson gson, ModelMapper modelMapper) {
        this.collateralTypeRepository = collateralTypeRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean isEmpty() {
        return this.collateralTypeRepository.count() == 0;
    }

    @Override
    public String readCollateralTypesFormFile() throws IOException {
        Path path = Path.of("src", "main", "resources", "files", "CollateralTypes.json");
        return Files.readString(path);
    }

    @Override
    public void seedCollateralTypes() throws IOException {
        if (isEmpty()) {
            String json = readCollateralTypesFormFile();
            CollateralTypeDTO[] collateralTypeDTOS = this.gson.fromJson(json, CollateralTypeDTO[].class);

            List<CollateralType> collateralTypeEntities = new ArrayList<>();

            Arrays.stream(collateralTypeDTOS).forEach(dto -> {
                CollateralType collateralType = this.modelMapper.map(dto, CollateralType.class);
                collateralTypeEntities.add(collateralType);
            });
            this.collateralTypeRepository.saveAll(collateralTypeEntities);

        }

    }

    @Override
    @PostConstruct
    public void init() throws IOException {
        if (isEmpty()) seedCollateralTypes();
    }

//    @Override
//    public void updateCollateralTypesMultipliers() {
//
//    }
//
//    @Override
//    public void updateCollateralTypesDescription() {
//
//    }

    @Override
    public List<CollateralTypeDTO> getCollateralTypesInfo() {
        return null;
    }

    @Override
    public Optional<CollateralType> getCollateralType(CollateralCategory collateralCategory) {
        return this.collateralTypeRepository.findByType(collateralCategory);
    }
}
