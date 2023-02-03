package com.example.collateralmanagement.web;

import com.example.collateralmanagement.models.dtos.business.AddLoanDTO;
import com.example.collateralmanagement.services.LoanService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/business/loans")
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping ("/addLoan")
    public String displayAddLoan(Model model){

        AddLoanDTO addLoanDTO = new AddLoanDTO();

        model.addAttribute("loan", addLoanDTO);

        return "addLoan";
    }
    @PostMapping ("/save")
    public String saveLoan(AddLoanDTO addLoanDTO, Model model){
        this.loanService.addLoan(addLoanDTO);
        return "redirect:/business";
    }
}
