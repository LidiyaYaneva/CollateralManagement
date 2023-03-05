package com.example.collateralmanagement.services.impl.otherServices;

import com.example.collateralmanagement.models.entities.asset.Asset;
import com.example.collateralmanagement.models.entities.business.BankClient;
import com.example.collateralmanagement.models.entities.business.Department;
import com.example.collateralmanagement.models.entities.business.Loan;
import com.example.collateralmanagement.models.entities.valuation.Evaluation;
import com.example.collateralmanagement.models.enums.ClientType;
import com.example.collateralmanagement.models.enums.DepartmentEnum;
import com.example.collateralmanagement.repositories.*;
import com.example.collateralmanagement.services.SeedService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class SeedServiceImpl implements SeedService {

    private final BankClientRepository bankClientRepository;

    private final LoanRepository loanRepository;

    private final AssetRepository assetRepository;

    private final CollateralRepository collateralRepository;

    private final AcquiredAssetRepository acquiredAssetRepository;

    private final EvaluationRepository evaluationRepository;

    private final DepartmentRepository departmentRepository;

    public SeedServiceImpl(BankClientRepository bankClientRepository, LoanRepository loanRepository,
                           AssetRepository assetRepository, CollateralRepository collateralRepository,
                           AcquiredAssetRepository acquiredAssetRepository,
                           EvaluationRepository evaluationRepository, DepartmentRepository departmentRepository) {
        this.bankClientRepository = bankClientRepository;
        this.loanRepository = loanRepository;
        this.assetRepository = assetRepository;
        this.collateralRepository = collateralRepository;
        this.acquiredAssetRepository = acquiredAssetRepository;
        this.evaluationRepository = evaluationRepository;
        this.departmentRepository = departmentRepository;
    }


    @Override
    public void seedExampleClients() {

        List<BankClient> clients = List.of(
                new BankClient("Lidiya Nikolaeva Yaneva", ClientType.INDIVIDUAL, "999999999", "Email: lidiya.yanev@gmail.com, phone 0883322346, address Sofia"),
                new BankClient("Radoslav Krasimirov Yanev", ClientType.INDIVIDUAL, "8888888888", "radoslav.yanev@example.com"),
                new BankClient("Software University LTD", ClientType.MIDDLE_SIZE_ENTERPRISE, "7777777777", " email: university@softuni.bg , phone + 359 899 55 55 92, address: Sofia, Mladost 4, bul Aleksandur Malinov 78"),
                new BankClient("Emir - 99 LTD", ClientType.SMALL_BUSINESS_ENTITY, "6666666666", "address: Pazardzhik"),
                new BankClient("Large Corporation LTD", ClientType.LARGE_ENTERPRISE, "1111111111", "example@example.com")
        );
        this.bankClientRepository.saveAll(clients);

    }

    @Override
    public void seedExampleLoans() {

        List<Loan> loans = List.of(
                new Loan("Loan-001", LocalDate.of(2023, 1, 2), true, "regular payments", BigDecimal.valueOf(120000)).setClientAndReturnLoan(this.bankClientRepository.findByIdentificationNumber("999999999").get()),
                new Loan("Loan-002", LocalDate.of(2020, 3, 15), true, "restructured, under strict monitoring", BigDecimal.valueOf(300000)).setClientAndReturnLoan(this.bankClientRepository.findByIdentificationNumber("6666666666").get()),
                new Loan("Loan-003", LocalDate.of(2021, 12, 8), true, "non collectable", BigDecimal.valueOf(80000)).setClientAndReturnLoan(this.bankClientRepository.findByIdentificationNumber("6666666666").get()),
                new Loan("Loan-004", LocalDate.of(2017, 5, 26), true, "regular payments", BigDecimal.valueOf(200000)).setClientAndReturnLoan(this.bankClientRepository.findByIdentificationNumber("7777777777").get()),
                new Loan("Loan-005", LocalDate.of(2010, 10, 23), false, "regular payments", BigDecimal.valueOf(60000)).setClientAndReturnLoan(this.bankClientRepository.findByIdentificationNumber("7777777777").get()),
                new Loan("Loan-006", LocalDate.of(2023, 1, 16), true, "regular payments", BigDecimal.valueOf(140000)).setClientAndReturnLoan(this.bankClientRepository.findByIdentificationNumber("1111111111").get()),
                new Loan("Loan-007", LocalDate.of(2022, 5, 28), true, "regular payments", BigDecimal.valueOf(15000)).setClientAndReturnLoan(this.bankClientRepository.findByIdentificationNumber("1111111111").get()),
                new Loan("Loan-008", LocalDate.of(2020, 11, 10), true, "regular payments", BigDecimal.valueOf(50000)).setClientAndReturnLoan(this.bankClientRepository.findByIdentificationNumber("1111111111").get()),
                new Loan("Loan-009", LocalDate.of(2019, 5, 26), true, "regular payments", BigDecimal.valueOf(100000)).setClientAndReturnLoan(this.bankClientRepository.findByIdentificationNumber("1111111111").get()),
                new Loan("Loan-010", LocalDate.of(2023, 2, 18), true, "regular payments", BigDecimal.valueOf(500000)).setClientAndReturnLoan(this.bankClientRepository.findByIdentificationNumber("1111111111").get()),
                new Loan("Loan-011", LocalDate.of(2010, 2, 3), false, "regular payments", BigDecimal.valueOf(200000)).setClientAndReturnLoan(this.bankClientRepository.findByIdentificationNumber("1111111111").get())
        );
        this.loanRepository.saveAll(loans);

    }

    @Override
    public void seedExampleAssets() {

        Department creditRisk = this.departmentRepository.findByName(DepartmentEnum.CREDIT_RISK).get();
        Department propertyAdministration = this.departmentRepository.findByName(DepartmentEnum.PROPERTY_ADMINISTRATION).get();

        List<Asset> assets = List.of(
                new Asset("Apartment number 68134.1003.79.285.121 Sofia, Mladost 2, blok 285, et 3, ap 121", "68134.1003.79.285.121", "Lidiya Yaneva, Radoslav Yanev", "Notarialen akt example", creditRisk),
                new Asset("Apartment number 68134.895.63.12.7 Sofia, Drujba 2, blok 221, et 1, ap 107", "68134.895.63.12.7", "Lidiya Yaneva, Radoslav Yanev", "Notarialen akt example", creditRisk),
                new Asset("Industrial property number 55155.111.22.1 Pazardzik ulica Industrialna 1", "55155.111.22.10.6", "Emir - 99 LTD", "Notarialen akt example", propertyAdministration),
                new Asset("Opel Zafira  number PA9194KK ", "PA9194KK", "Emir - 99 LTD", "Notarialen akt example", creditRisk),
                new Asset("Office Building number 68134.333.22.1 Sofia Mladost 2", "68134.333.22.1", "Software University LTD", "Notarialen akt example", creditRisk),
                new Asset("Office Building number 68134.444.33.2 Sofia Iztok", "68134.444.33.2", "Software University LTD", "Notarialen akt example", creditRisk),
                new Asset("Hotel Example", "XXXXX.XXX.XX.1", "Large Corporation LTD", "Notarialen akt example", creditRisk),
                new Asset("Restaurant Example", "XXXXX.XXX.XX.2", "Large Corporation LTD", "Notarialen akt example", creditRisk),
                new Asset("Gas Station Example", "YYYYY.XXX.XX.3", "Large Corporation LTD", "Notarialen akt example", creditRisk),
                new Asset("Mall Example", "XXXXX.XXX.XX.4", "Large Corporation LTD", "Notarialen akt example", creditRisk),
                new Asset("Office Building Example", "XXXXX.XXX.XX.5", "Large Corporation LTD", "Notarialen akt example", creditRisk),
                new Asset("Construction equipment Example", "Construction equipment", "Large Corporation LTD", "Notarialen akt example", creditRisk),
                new Asset("Administrative office", "YYYYY.YYY.YY.Y.1", "Example bank", "Notarialen akt example", propertyAdministration)
        );
        this.assetRepository.saveAll(assets);

    }

    @Override
    public void seedExampleCollaterals() {

    }

    @Override
    public void seedExampleAcquiredAssets() {

    }

    @Override
    public void seedExampleEvaluations() {

    }

    @Override
    public void seedAllExamples() {

        if (this.bankClientRepository.count() == 0) seedExampleClients();
        if (this.loanRepository.count() == 0) seedExampleLoans();
        if (this.assetRepository.count() == 0) seedExampleAssets();
        if (this.collateralRepository.count() == 0) seedExampleCollaterals();
        if (this.acquiredAssetRepository.count() == 0) seedExampleAcquiredAssets();
        if (this.evaluationRepository.count() == 0) seedExampleEvaluations();

    }

    @Override
    public void seedAllInitialData() {
       // TODO
    }
}
