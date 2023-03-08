package com.example.collateralmanagement.services.impl.assetServices;

import com.example.collateralmanagement.models.dtos.asset.CreateCollateralDTO;
import com.example.collateralmanagement.models.dtos.asset.DisplayCollateralDTO;
import com.example.collateralmanagement.models.dtos.asset.SearchDTO;
import com.example.collateralmanagement.models.entities.asset.Asset;
import com.example.collateralmanagement.models.entities.asset.Collateral;
import com.example.collateralmanagement.models.entities.asset.CollateralType;
import com.example.collateralmanagement.models.entities.business.Loan;
import com.example.collateralmanagement.models.enums.CollateralCategory;
import com.example.collateralmanagement.repositories.AssetRepository;
import com.example.collateralmanagement.repositories.CollateralRepository;
import com.example.collateralmanagement.repositories.CollateralTypeRepository;
import com.example.collateralmanagement.repositories.LoanRepository;
import com.example.collateralmanagement.services.CollateralService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class CollateralServiceImpl implements CollateralService {

    private final CollateralRepository collateralRepository;

    private final LoanRepository loanRepository;

    private final AssetRepository assetRepository;


    @Autowired
    public CollateralServiceImpl(CollateralRepository collateralRepository, LoanRepository loanRepository, AssetRepository assetRepository, ModelMapper modelMapper) {
        this.collateralRepository = collateralRepository;
        this.loanRepository = loanRepository;
        this.assetRepository = assetRepository;
    }

    @Override
    public void addCollateral(CreateCollateralDTO createCollateralDTO) {

        LocalDate dateOfLinkToLoans = createCollateralDTO.getDateOfLinkToLoan();
        Long assetId = createCollateralDTO.getAssetId();
        String loanNumber = createCollateralDTO.getLoanNumber();

        Optional<Asset> asset = this.assetRepository.findById(assetId);
        Optional<Loan> loan = this.loanRepository.findByLoanNumber(loanNumber);
        if (asset.isPresent() && loan.isPresent()) {

            Collateral collateralEntity = new Collateral();
            collateralEntity.setDateOfLinkToLoan(dateOfLinkToLoans);
            collateralEntity.setAsset(asset.get());
            Set<Loan> loans = new HashSet<>();
            loans.add(loan.get());
            collateralEntity.setLoans(loans);

            this.collateralRepository.save(collateralEntity);
            Set<Collateral> loansCollaterals = loan.get().getCollaterals();
            loansCollaterals.add(collateralEntity);
            this.loanRepository.save(loan.get());
        }

    }

    @Override
    public boolean deleteCollateral(Long id) {
        return false;
    }

    @Override
    public List<DisplayCollateralDTO> findCollateralsOfRecentLoans() {
        return null;
    }

    @Override
    public List<DisplayCollateralDTO> displayCollateralsBySearchInput(SearchDTO searchDTO) {
        return null;
    }
}
