package com.example.collateralmanagement;

import com.example.collateralmanagement.models.dtos.asset.AddAcquiredAssetDTO;
import com.example.collateralmanagement.models.dtos.asset.CreateAssetDTO;
import com.example.collateralmanagement.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final BankClientService bankClientService;

    private final LoanService loanService;

    private final DepartmentService departmentService;

    private final AssetService assetService;

    private final CollateralTypeService collateralTypeService;

    private final AcquiredAssetService acquiredAssetService;

    private final UserService userService;

    private final Scanner scanner;
    private  final PasswordEncoder encoder;

    public ConsoleRunner(BankClientService bankClientService, LoanService loanService, DepartmentService departmentService, AssetService propertyItemService, CollateralTypeService collateralTypeService, AcquiredAssetService acquiredAssetService, UserService userService, Scanner scanner, PasswordEncoder encoder) {
        this.bankClientService = bankClientService;
        this.loanService = loanService;
        this.departmentService = departmentService;
        this.assetService = propertyItemService;
        this.collateralTypeService = collateralTypeService;
        this.acquiredAssetService = acquiredAssetService;
        this.userService = userService;
        this.scanner = scanner;
        this.encoder = encoder;
    }

    @Override
    public void run(String... args) throws Exception {

        if (departmentService.isEmpty()){
            departmentService.seedDepartments();
        }
        if (collateralTypeService.isEmpty()){
            collateralTypeService.seedCollateralTypes();
        }

//        RegisterUserDTO registerUserDTO = new RegisterUserDTO("Ivan", "Dimitrov",
//                "ivan.dimitrov@bank.com","IvanDimitrov", "encodertest", "MANAGEMENT");
//        this.userService.registerUser(registerUserDTO);

//        AddClientDTO importClientDTO= new AddClientDTO("BUY-BG Ltd.",
//                "SMALL_BUSINESS_ENTITY", "1111111111", "office@buy-bg.com");
//        AddLoanDTO importLoanDTO = new AddLoanDTO("loan-2022-0000000001",
//                "2022-12-21", true, "minRisk", BigDecimal.valueOf(25000),"1111111111" );
//        this.bankClientService.addClient(importClientDTO);
//        this.loanService.addLoan(importLoanDTO);

        CreateAssetDTO createAssetDTO = new CreateAssetDTO("some description new test 6", "keyword test new 6","Example 6",
                "example ownership doc new 6", "PROPERTY_ADMINISTRATION");
        this.assetService.createAsset(createAssetDTO);

        //yyyy-MM-dd
        AddAcquiredAssetDTO addAcquiredAssetDTO = new AddAcquiredAssetDTO( 1L, "2023-01-03", "2023-01-31",
                "example Strategy", true);
        this.acquiredAssetService.addAcquiredAsset(addAcquiredAssetDTO);
    }
}
