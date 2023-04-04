package com.example.collateralmanagement.services.impl.valuationServices;

import com.example.collateralmanagement.models.dtos.valuation.AddAppraisalCompanyDTO;
import com.example.collateralmanagement.models.entities.valuation.AppraisalCompany;
import com.example.collateralmanagement.repositories.AppraisalCompanyRepository;
import com.example.collateralmanagement.services.AppraisalCompaniesService;
import com.google.gson.Gson;
import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class AppraisalCompanyImpl implements AppraisalCompaniesService {

    private final AppraisalCompanyRepository appraisalCompanyRepository;

    private final Logger LOGGER = LoggerFactory.getLogger(AppraisalCompanyImpl.class);

    private final ModelMapper modelMapper;

    private final Gson gson;

    @Autowired
    public AppraisalCompanyImpl(AppraisalCompanyRepository appraisalCompanyRepository, ModelMapper modelMapper, Gson gson) {
        this.appraisalCompanyRepository = appraisalCompanyRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @Override
    public void addAppraisalCompany(AddAppraisalCompanyDTO addAppraisalCompanyDTO) {

        String bulstat = addAppraisalCompanyDTO.getCompanyBULSTAT();

        Optional<AppraisalCompany> optionalAppraisalCompany = this.appraisalCompanyRepository
                .findByCompanyBULSTAT(bulstat);
        if (optionalAppraisalCompany.isPresent()) {
            LOGGER.info("Appraisal Company with BULSTAT [{}] already exists", bulstat);
        } else {
            AppraisalCompany appraisalCompany = this.modelMapper
                    .map(addAppraisalCompanyDTO, AppraisalCompany.class);
            this.appraisalCompanyRepository.save(appraisalCompany);
        }

    }

    @Override
    public boolean deleteAppraisalCompany(String companyBULSTAT) {
        Optional<AppraisalCompany> appraisalCompany = this.appraisalCompanyRepository
                .findByCompanyBULSTAT(companyBULSTAT);
        if (appraisalCompany.isEmpty()) {
            LOGGER.info("Appraisal company with  [{}] not found", companyBULSTAT);
            return false;
        } else {
            this.appraisalCompanyRepository.delete(appraisalCompany.get());
            return true;
        }
    }

    @Override
    public boolean isEmpty() {
        return this.appraisalCompanyRepository.count() == 0;

    }

    @Override
    public String readAppraisalCompaniesFormFile() throws IOException {
        Path path = Path.of("src", "main", "resources", "files", "AppraisalCompanies.json");
        return Files.readString(path);
    }

    @Override
    public void seedAppraisalCompanies() throws IOException {

        if (isEmpty()) {
            String json = readAppraisalCompaniesFormFile();
            AddAppraisalCompanyDTO[] addAppraisalCompanyDTOS = this.gson.fromJson(json, AddAppraisalCompanyDTO[].class);

            List<AppraisalCompany> appraisalCompanies = new ArrayList<>();

            Arrays.stream(addAppraisalCompanyDTOS).forEach(dto -> {
                AppraisalCompany appraisalCompany = this.modelMapper.map(dto, AppraisalCompany.class);
                appraisalCompanies.add(appraisalCompany);
            });
            this.appraisalCompanyRepository.saveAll(appraisalCompanies);

        }


    }

    @Override
    @PostConstruct
    public void init() throws IOException {
        if (isEmpty()) seedAppraisalCompanies();
    }
}
