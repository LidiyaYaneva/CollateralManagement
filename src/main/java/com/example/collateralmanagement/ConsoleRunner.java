package com.example.collateralmanagement;

import com.example.collateralmanagement.models.dtos.business.AddClientDTO;
import com.example.collateralmanagement.models.dtos.business.AddLoanDTO;
import com.example.collateralmanagement.models.dtos.asset.CreateAssetDTO;
import com.example.collateralmanagement.models.dtos.user.RegisterUserDTO;
import com.example.collateralmanagement.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Scanner;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final BankClientService bankClientService;

    private final LoanService loanService;

    private final DepartmentService departmentService;

    private final AssetService propertyItemService;

    private final CollateralTypeService collateralTypeService;

    private final UserService userService;

    private final Scanner scanner;
    private  final PasswordEncoder encoder;

    public ConsoleRunner(BankClientService bankClientService, LoanService loanService, DepartmentService departmentService, AssetService propertyItemService, CollateralTypeService collateralTypeService, UserService userService, Scanner scanner, PasswordEncoder encoder) {
        this.bankClientService = bankClientService;
        this.loanService = loanService;
        this.departmentService = departmentService;
        this.propertyItemService = propertyItemService;
        this.collateralTypeService = collateralTypeService;
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

        RegisterUserDTO registerUserDTO = new RegisterUserDTO("Ivan", "Dimitrov",
                "ivan.dimitrov@bank.com","IvanDimitrov", "encodertest", "MANAGEMENT");
        this.userService.registerUser(registerUserDTO);

        AddClientDTO importClientDTO= new AddClientDTO("BUY-BG Ltd.",
                "SMALL_BUSINESS_ENTITY", "1111111111", "office@buy-bg.com");
        AddLoanDTO importLoanDTO = new AddLoanDTO("loan-2022-0000000001",
                "2022-12-21", true, "minRisk", BigDecimal.valueOf(25000),"1111111111" );
        this.bankClientService.addClient(importClientDTO);
        this.loanService.addLoan(importLoanDTO);

        CreateAssetDTO createAssetDTO = new CreateAssetDTO("some description", "keyword test","Example Owner",
                "example ownership doc", "CREDIT_RISK");
        this.propertyItemService.createAsset(createAssetDTO);
    }
}
