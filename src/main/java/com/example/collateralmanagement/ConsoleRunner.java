package com.example.collateralmanagement;

import com.example.collateralmanagement.models.dtos.business.ImportClientDTO;
import com.example.collateralmanagement.models.dtos.business.ImportLoanDTO;
import com.example.collateralmanagement.services.BankClientService;
import com.example.collateralmanagement.services.LoanService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final BankClientService bankClientService;

    private final LoanService loanService;

    private final Scanner scanner;

    public ConsoleRunner(BankClientService bankClientService, LoanService loanService, Scanner scanner) {
        this.bankClientService = bankClientService;
        this.loanService = loanService;
        this.scanner = scanner;
    }

    @Override
    public void run(String... args) throws Exception {

        ImportClientDTO importClientDTO= new ImportClientDTO("BUY-BG Ltd.",
                "SMALL_BUSINESS_ENTITY", "1111111111", "office@buy-bg.com");
        ImportLoanDTO importLoanDTO = new ImportLoanDTO("loan-2022-0000000001",
                "2022-12-21", true, "minRisk", "1111111111" );
        this.bankClientService.addClient(importClientDTO);
        this.loanService.addLoan(importLoanDTO);
    }
}
