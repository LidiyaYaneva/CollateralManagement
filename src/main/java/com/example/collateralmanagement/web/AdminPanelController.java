package com.example.collateralmanagement.web;

import com.example.collateralmanagement.models.dtos.user.RegisterUserDTO;
import com.example.collateralmanagement.services.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/adminPanel")
public class AdminPanelController {

    private final UserService userService;

    public AdminPanelController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String displayRegisterForm (Model model){

        RegisterUserDTO registerUserDTO = new RegisterUserDTO();

        model.addAttribute("user", registerUserDTO);

        return "register";

    }

    @PostMapping("/save")
    public String register(@Valid RegisterUserDTO registerUserDTO, BindingResult bindingResult,
                           RedirectAttributes redirectAttributes, Model model){

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("registerUserDTO", registerUserDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registerUserDTO", bindingResult);
            return "redirect:/adminPanel/register";
        }
        this.userService.registerUser(registerUserDTO);
        return "redirect:/adminPanel";

    }
}
