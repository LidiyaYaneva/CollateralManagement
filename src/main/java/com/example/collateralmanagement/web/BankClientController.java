package com.example.collateralmanagement.web;

import com.example.collateralmanagement.models.dtos.business.AddClientDTO;
import com.example.collateralmanagement.services.BankClientService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/business/clients")
public class BankClientController {

    private final BankClientService bankClientService;

    public BankClientController(BankClientService bankClientService) {
        this.bankClientService = bankClientService;
    }

//    @GetMapping("/")
//    public String getAllClients(Model model){
//        return "something";
//    }

    @GetMapping ("/addNewClient")
    public String displayAddClientForm (Model model){

        AddClientDTO addClientDTO = new AddClientDTO();
        model.addAttribute("bankClient",addClientDTO);

        return "addNewClient";
    }

    @PostMapping( "/save")
    public String saveClient (@Valid AddClientDTO addClientDTO, BindingResult bindingResult,
                              RedirectAttributes redirectAttributes,Model model){

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("addClientDTO", addClientDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addClientDTO", bindingResult);
            return "redirect:/business/clients/addNewClient";
        }
        this.bankClientService.addClient(addClientDTO);
        return "redirect:/business";

    }


}
