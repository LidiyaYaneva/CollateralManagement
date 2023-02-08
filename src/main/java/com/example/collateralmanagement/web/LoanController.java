package com.example.collateralmanagement.web;

import com.example.collateralmanagement.models.dtos.business.AddLoanDTO;
import com.example.collateralmanagement.services.LoanService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/business/loans")
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @ModelAttribute ("addLoanDTO")
    public AddLoanDTO init (Model model) {
        AddLoanDTO addLoanDTO = new AddLoanDTO();
        model.addAttribute("addLoanDTO",addLoanDTO);
        return addLoanDTO;
    }

    @GetMapping ("/addLoan")
    public String displayAddLoan(){

        return "addLoan";
    }
    @PostMapping ("/save")
    public String saveLoan(@Valid AddLoanDTO addLoanDTO, BindingResult bindingResult,
                           RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("addLoanDTO", addLoanDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addLoanDTO", bindingResult);
            return "redirect:/business/loans/addLoan";
        }
        this.loanService.addLoan(addLoanDTO);
        return "redirect:/business";
    }
}
