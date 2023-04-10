package com.example.collateralmanagement.services.impl.otherServices;

import com.example.collateralmanagement.models.entities.asset.AcquiredAsset;
import com.example.collateralmanagement.models.entities.asset.Asset;
import com.example.collateralmanagement.models.entities.asset.CollateralType;
import com.example.collateralmanagement.models.entities.business.BankClient;
import com.example.collateralmanagement.models.entities.business.Department;
import com.example.collateralmanagement.models.entities.business.Loan;
import com.example.collateralmanagement.models.enums.ClientType;
import com.example.collateralmanagement.models.enums.CollateralCategory;
import com.example.collateralmanagement.models.enums.DepartmentEnum;
import com.example.collateralmanagement.repositories.*;
import com.example.collateralmanagement.services.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class SeedServiceImpl implements SeedService {

    private final BankClientRepository bankClientRepository;

    private final LoanRepository loanRepository;

    private final AssetRepository assetRepository;

    private final CollateralRepository collateralRepository;

    private final AcquiredAssetRepository acquiredAssetRepository;

    private final EvaluationRepository evaluationRepository;

    private final UserService userService;

    private final DepartmentService departmentService;

    private final CollateralTypeService collateralTypeService;

    private final AppraisalCompaniesService appraisalCompaniesService;


    public SeedServiceImpl(BankClientRepository bankClientRepository, LoanRepository loanRepository,
                           AssetRepository assetRepository, CollateralRepository collateralRepository,
                           AcquiredAssetRepository acquiredAssetRepository,
                           EvaluationRepository evaluationRepository, UserService userService, DepartmentService departmentService, CollateralTypeService collateralTypeService, AppraisalCompaniesService appraisalCompaniesService) {
        this.bankClientRepository = bankClientRepository;
        this.loanRepository = loanRepository;
        this.assetRepository = assetRepository;
        this.collateralRepository = collateralRepository;
        this.acquiredAssetRepository = acquiredAssetRepository;
        this.evaluationRepository = evaluationRepository;
        this.userService = userService;
        this.departmentService = departmentService;
        this.collateralTypeService = collateralTypeService;

        this.appraisalCompaniesService = appraisalCompaniesService;
    }


    @Override
    public void seedExampleClients() {

        List<BankClient> clients = List.of(
                new BankClient("Lidiya Nikolaeva Yaneva", ClientType.INDIVIDUAL, "999999999", "Email: lidiya.yanev@gmail.com, phone 0883322346, address Sofia"),
                new BankClient("Radoslav Krasimirov Yanev", ClientType.INDIVIDUAL, "999999998", "radoslav.yanev@example.com"),
                new BankClient("Valentina Ivanova Todorova", ClientType.INDIVIDUAL, "8888888888", "v.todorova@example.com"),
                new BankClient("Software University LTD", ClientType.MIDDLE_SIZE_ENTERPRISE, "7777777777", " email: university@softuni.bg , phone + 359 899 55 55 92, address: Sofia, Mladost 4, bul Aleksandur Malinov 78"),
                new BankClient("Emir - 99 LTD", ClientType.SMALL_BUSINESS_ENTITY, "6666666666", "address: Pazardzhik"),
                new BankClient("Large Corporation LTD", ClientType.LARGE_ENTERPRISE, "1111111111", "example@example.com")
        );
        this.bankClientRepository.saveAll(clients);

    }

    @Override
    public void seedExampleLoans() {

        List<Loan> loans = List.of(
                new Loan("Loan-001", LocalDate.of(2023, 1, 2), true, "regular payments", BigDecimal.valueOf(120000)).setClientAndReturnLoan(this.bankClientRepository.findByIdentificationNumber("999999999").orElse(null)),
                new Loan("Loan-002", LocalDate.of(2020, 3, 15), true, "restructured, under strict monitoring", BigDecimal.valueOf(300000)).setClientAndReturnLoan(this.bankClientRepository.findByIdentificationNumber("6666666666").orElse(null)),
                new Loan("Loan-003", LocalDate.of(2021, 12, 8), true, "non collectable", BigDecimal.valueOf(80000)).setClientAndReturnLoan(this.bankClientRepository.findByIdentificationNumber("6666666666").orElse(null)),
                new Loan("Loan-004", LocalDate.of(2017, 5, 26), true, "regular payments", BigDecimal.valueOf(200000)).setClientAndReturnLoan(this.bankClientRepository.findByIdentificationNumber("7777777777").orElse(null)),
                new Loan("Loan-005", LocalDate.of(2010, 10, 23), false, "regular payments", BigDecimal.valueOf(60000)).setClientAndReturnLoan(this.bankClientRepository.findByIdentificationNumber("7777777777").orElse(null)),
                new Loan("Loan-006", LocalDate.of(2023, 1, 16), true, "regular payments", BigDecimal.valueOf(140000)).setClientAndReturnLoan(this.bankClientRepository.findByIdentificationNumber("1111111111").orElse(null)),
                new Loan("Loan-007", LocalDate.of(2022, 5, 28), true, "regular payments", BigDecimal.valueOf(15000)).setClientAndReturnLoan(this.bankClientRepository.findByIdentificationNumber("1111111111").orElse(null)),
                new Loan("Loan-008", LocalDate.of(2020, 11, 10), true, "regular payments", BigDecimal.valueOf(50000)).setClientAndReturnLoan(this.bankClientRepository.findByIdentificationNumber("1111111111").orElse(null)),
                new Loan("Loan-009", LocalDate.of(2019, 5, 26), true, "regular payments", BigDecimal.valueOf(100000)).setClientAndReturnLoan(this.bankClientRepository.findByIdentificationNumber("1111111111").orElse(null)),
                new Loan("Loan-010", LocalDate.of(2023, 2, 18), true, "regular payments", BigDecimal.valueOf(500000)).setClientAndReturnLoan(this.bankClientRepository.findByIdentificationNumber("1111111111").orElse(null)),
                new Loan("Loan-011", LocalDate.of(2010, 2, 3), false, "regular payments", BigDecimal.valueOf(200000)).setClientAndReturnLoan(this.bankClientRepository.findByIdentificationNumber("1111111111").orElse(null))
        );
        this.loanRepository.saveAll(loans);

    }

    @Override
    public void seedExampleAssets() {

        Optional<Department> creditRisk = this.departmentService.findByName(DepartmentEnum.CREDIT_RISK);
        Optional<Department> propertyAdministration = this.departmentService.findByName(DepartmentEnum.PROPERTY_ADMINISTRATION);

        Optional<CollateralType> apartment = this.collateralTypeService.getCollateralType(CollateralCategory.APARTMENT);
        Optional<CollateralType> house = this.collateralTypeService.getCollateralType(CollateralCategory.HOUSE);
        Optional<CollateralType> car = this.collateralTypeService.getCollateralType(CollateralCategory.TRANSPORTATION_VEHICLES);
        Optional<CollateralType> warehouse = this.collateralTypeService.getCollateralType(CollateralCategory.PRODUCTION_AND_STORAGE_PREMISE_IN_RESIDENTIAL_AREAS);
        Optional<CollateralType> officeBuilding = this.collateralTypeService.getCollateralType(CollateralCategory.ADMINISTRATIVE_BUILDING);
        Optional<CollateralType> hotel = this.collateralTypeService.getCollateralType(CollateralCategory.HOTEL);
        Optional<CollateralType> restaurant = this.collateralTypeService.getCollateralType(CollateralCategory.RESTAURANT);
        Optional<CollateralType> gasStation = this.collateralTypeService.getCollateralType(CollateralCategory.GAS_STATION);
        Optional<CollateralType> mall = this.collateralTypeService.getCollateralType(CollateralCategory.COMMERCIAL_BUILDING);
        Optional<CollateralType> constructionEquipment = this.collateralTypeService.getCollateralType(CollateralCategory.PRODUCTION_MACHINERY_AND_EQUIPMENT);
        Optional<CollateralType> office = this.collateralTypeService.getCollateralType(CollateralCategory.OFFICE);

        List<Asset> assets = List.of(
                new Asset(apartment.orElse(null),"Apartment number 68134.1003.79.285.121 Sofia, Mladost 2, blok 285, et 3, ap 121", "68134.1003.79.285.121", "Lidiya Yaneva, Radoslav Yanev", "Notarialen akt example", creditRisk.orElse(null)),
                new Asset(apartment.orElse(null),"Apartment number 68134.895.63.12.7 Sofia, Drujba 2, blok 221, et 1, ap 107", "68134.895.63.12.7", "Lidiya Yaneva, Radoslav Yanev", "Notarialen akt example", creditRisk.orElse(null)),
                new Asset(house.orElse(null),"House  389002.895.63.1 Kostenec, ulica Raiko Daskalov 3", "389002.895.63.1", "Valentina Ivanova Todorova", "Notarialen akt example", creditRisk.orElse(null)),
                new Asset(car.orElse(null),"Ford Galaxy number CO1234XX", "CO1234XX", "Nikolay Borisov Vasilev", "Example", creditRisk.orElse(null)),
                new Asset(warehouse.orElse(null),"Industrial property number 55155.111.22.1 Pazardzik ulica Industrialna 1", "55155.111.22.10.6", "Emir - 99 LTD", "Notarialen akt example", propertyAdministration.orElse(null)),
                new Asset(car.orElse(null),"Opel Zafira  number PA9194KK ", "PA9194KK", "Emir - 99 LTD", "Example", creditRisk.orElse(null)),
                new Asset(officeBuilding.orElse(null),"Office Building number 68134.333.22.1 Sofia Mladost 2", "68134.333.22.1", "Software University LTD", "Notarialen akt example", creditRisk.orElse(null)),
                new Asset(officeBuilding.orElse(null),"Office Building number 68134.444.33.2 Sofia Iztok", "68134.444.33.2", "Software University LTD", "Notarialen akt example", creditRisk.orElse(null)),
                new Asset(hotel.orElse(null),"Hotel Example", "XXXXX.XXX.XX.1", "Large Corporation LTD", "Notarialen akt example", creditRisk.orElse(null)),
                new Asset(restaurant.orElse(null),"Restaurant Example", "XXXXX.XXX.XX.2", "Large Corporation LTD", "Notarialen akt example", creditRisk.orElse(null)),
                new Asset(gasStation.orElse(null),"Gas Station Example", "YYYYY.XXX.XX.3", "Large Corporation LTD", "Notarialen akt example", creditRisk.orElse(null)),
                new Asset(mall.orElse(null),"Mall Example", "XXXXX.XXX.XX.4", "Large Corporation LTD", "Notarialen akt example", creditRisk.orElse(null)),
                new Asset(officeBuilding.orElse(null),"Office Building Example", "XXXXX.XXX.XX.5", "Large Corporation LTD", "Notarialen akt example", creditRisk.orElse(null)),
                new Asset(constructionEquipment.orElse(null),"Construction equipment Example", "Construction equipment", "Large Corporation LTD", "Notarialen akt example", creditRisk.orElse(null)),
                new Asset(office.orElse(null),"Administrative office", "YYYYY.YYY.YY.Y.1", "Example bank", "Notarialen akt example", propertyAdministration.orElse(null))
        );
        this.assetRepository.saveAll(assets);

    }

    @Override
    public void seedExampleCollaterals() {

    }

    @Override
    public void seedExampleAcquiredAssets() {
        List<AcquiredAsset> acquiredAssets = List.of(
                new AcquiredAsset(this.assetRepository.findById(5L).orElse(null), LocalDate.of(2021,11,5),LocalDate.of(2022,6,25),"outsource to a real estate agency", false),
                new AcquiredAsset(this.assetRepository.findById(15L).orElse(null), LocalDate.of(2022,1,9),null,"use as our own office after acquiring ", false),
                new AcquiredAsset(this.assetRepository.findById(3L).orElse(null), LocalDate.of(2022,2,1),null,"collect rent", true)
        );
        this.acquiredAssetRepository.saveAll(acquiredAssets);

    }

    @Override
    public void seedExampleEvaluations() {

    }

    @Override
    public void seedExampleUsers() {
        this.userService.initAdmin();

    }



    @Override
    public void seedAllExamples() {

        if (this.bankClientRepository.count() == 0) seedExampleClients();
        if (this.loanRepository.count() == 0) seedExampleLoans();
        if (this.assetRepository.count() == 0) seedExampleAssets();
        if (this.collateralRepository.count() == 0) seedExampleCollaterals();
        if (this.acquiredAssetRepository.count() == 0) seedExampleAcquiredAssets();
        if (this.evaluationRepository.count() == 0) seedExampleEvaluations();
        if(this.userService.isEmpty()) seedExampleUsers();

    }
}
