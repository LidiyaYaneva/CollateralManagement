package com.example.collateralmanagement;

import com.example.collateralmanagement.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final SeedService seedService;

    private final DepartmentService departmentService;

    private final CollateralTypeService collateralTypeService;

    private final AppraisalCompaniesService appraisalCompaniesService;

    private final UserService userService;

    private  final PasswordEncoder encoder;

    public ConsoleRunner( SeedService seedService, DepartmentService departmentService, CollateralTypeService collateralTypeService, AppraisalCompaniesService appraisalCompaniesService, UserService userService, PasswordEncoder encoder) {
        this.seedService = seedService;
        this.departmentService = departmentService;
        this.collateralTypeService = collateralTypeService;
        this.appraisalCompaniesService = appraisalCompaniesService;
        this.userService = userService;
        this.encoder = encoder;
    }

    @Override
    public void run(String... args) throws Exception {

        this.seedService.seedAllInitialData();

        if (departmentService.isEmpty()){
            departmentService.seedDepartments();
        }
        if (collateralTypeService.isEmpty()){
            collateralTypeService.seedCollateralTypes();
        }
        if (appraisalCompaniesService.isEmpty()){
            appraisalCompaniesService.seedAppraisalCompanies();
        }

        this.seedService.seedAllExamples();


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
