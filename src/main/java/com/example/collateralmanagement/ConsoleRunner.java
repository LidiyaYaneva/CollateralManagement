package com.example.collateralmanagement;

import com.example.collateralmanagement.models.dtos.asset.AddAcquiredAssetDTO;
import com.example.collateralmanagement.models.dtos.asset.CreateAssetDTO;
import com.example.collateralmanagement.models.dtos.business.AddClientDTO;
import com.example.collateralmanagement.models.dtos.business.AddLoanDTO;
import com.example.collateralmanagement.models.dtos.user.RegisterUserDTO;
import com.example.collateralmanagement.models.dtos.valuation.AddAppraisalCompanyDTO;
import com.example.collateralmanagement.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Scanner;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final BankClientService bankClientService;

    private final LoanService loanService;

    private final DepartmentService departmentService;

    private final AssetService assetService;

    private final CollateralTypeService collateralTypeService;

    private final AcquiredAssetService acquiredAssetService;

    private final AppraisalCompaniesService appraisalCompaniesService;

    private final UserService userService;

    private final Scanner scanner;
    private  final PasswordEncoder encoder;

    public ConsoleRunner(BankClientService bankClientService, LoanService loanService, DepartmentService departmentService, AssetService propertyItemService, CollateralTypeService collateralTypeService, AcquiredAssetService acquiredAssetService, AppraisalCompaniesService appraisalCompaniesService, UserService userService, Scanner scanner, PasswordEncoder encoder) {
        this.bankClientService = bankClientService;
        this.loanService = loanService;
        this.departmentService = departmentService;
        this.assetService = propertyItemService;
        this.collateralTypeService = collateralTypeService;
        this.acquiredAssetService = acquiredAssetService;
        this.appraisalCompaniesService = appraisalCompaniesService;
        this.userService = userService;
        this.scanner = scanner;
        this.encoder = encoder;
    }

    @Override
    public void run(String... args) throws Exception {

//        if (departmentService.isEmpty()){
//            departmentService.seedDepartments();
//        }
//        if (collateralTypeService.isEmpty()){
//            collateralTypeService.seedCollateralTypes();
//        }
//        if (appraisalCompaniesService.isEmpty()){
//            appraisalCompaniesService.seedAppraisalCompanies();
//        }
//
//        RegisterUserDTO registerUserDTO = new RegisterUserDTO("Ivan", "Dimitrov",
//                "ivan.dimitrov@bank.com","IvanDimitrov", "encodertest", "MANAGEMENT");
//        this.userService.registerUser(registerUserDTO);

//        AddClientDTO importClientDTO= new AddClientDTO("BUY-BG Ltd.",
//                "SMALL_BUSINESS_ENTITY", "1111111111", "office@buy-bg.com");
//
//        AddClientDTO importClientDTO2= new AddClientDTO("Test Ltd.",
//                "SMALL_BUSINESS_ENTITY", "2222222222", "office@test.com");
//
//        AddLoanDTO importLoanDTO = new AddLoanDTO("loan-2022-0000000001",
//                "2022-12-21", true, "minRisk", BigDecimal.valueOf(25000),"1111111111" );
//        this.bankClientService.addClient(importClientDTO2);
//        this.bankClientService.addClient(importClientDTO);
//       this.loanService.addLoan(importLoanDTO);
//
//        AddLoanDTO importLoanDTO2 = new AddLoanDTO("loan-2022-0000000002",
//                "2022-12-30", true, "minRisk", BigDecimal.valueOf(100000),"1111111111" );
//        this.bankClientService.addClient(importClientDTO);        this.loanService.addLoan(importLoanDTO);
//
//        AddLoanDTO importLoanDTO3 = new AddLoanDTO("loan-2023-0000000003",
//                "2023-01-19", true, "minRisk", BigDecimal.valueOf(17000),"2222222222" );
//        this.bankClientService.addClient(importClientDTO);        this.loanService.addLoan(importLoanDTO);
//
//        this.loanService.addLoan(importLoanDTO2);
//        this.loanService.addLoan(importLoanDTO3);
//
//        CreateAssetDTO createAssetDTO = new CreateAssetDTO("some description new test 6", "keyword test new 6","Example 6",
//                "example ownership doc new 6", "PROPERTY_ADMINISTRATION");
//        this.assetService.createAsset(createAssetDTO);


//        AddAcquiredAssetDTO addAcquiredAssetDTO = new AddAcquiredAssetDTO( 1L, "2023-01-03", Optional.empty(),
//                "example Strategy", true);
//        this.acquiredAssetService.addAcquiredAsset(addAcquiredAssetDTO);
//       AddAcquiredAssetDTO addAcquiredAssetDTO = new AddAcquiredAssetDTO( 5L, "2023-01-03", Optional.empty(),
//                "example Strategy", true);
//        this.acquiredAssetService.addAcquiredAsset(addAcquiredAssetDTO);
//        AddAppraisalCompanyDTO addAppraisalCompanyDTO = new AddAppraisalCompanyDTO("Test", "130983569");
//        this.appraisalCompaniesService.deleteAppraisalCompany("130983569");

    }
}
