package com.example.collateralmanagement.web.business;

import com.example.collateralmanagement.services.BankClientService;
import com.example.collateralmanagement.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/business")
public class BusinessController {

    private final BankClientService bankClientService;

    private final LoanService loanService;

    @Autowired
    public BusinessController(BankClientService bankClientService, LoanService loanService) {
        this.bankClientService = bankClientService;
        this.loanService = loanService;
    }

    @GetMapping("/statistics")
    public String displayBusinessStatistics(){
        return "businessStatistics";
    }
}
