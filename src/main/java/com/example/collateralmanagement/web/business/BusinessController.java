package com.example.collateralmanagement.web.business;

import com.example.collateralmanagement.models.dtos.business.DisplayClientDTO;
import com.example.collateralmanagement.models.dtos.business.DisplayLoanDTO;
import com.example.collateralmanagement.services.BankClientService;
import com.example.collateralmanagement.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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


    @GetMapping
    public String displayBusinessPage (Model model) {

        List<DisplayClientDTO> displayClientDTOS = this.bankClientService.findAllOrderedByName();
        model.addAttribute("displayClientDTOS",displayClientDTOS);
        List<DisplayLoanDTO> displayLoanDTOS = this.loanService.findAllActiveOrderedByIssueDateDesc();
        model.addAttribute("displayLoanDTOS", displayLoanDTOS);

        //TODO Implement Pages

        return "business";
    }
    @GetMapping("/statistics")
    public String displayBusinessStatistics(){
        return "businessStatistics";
    }
}
