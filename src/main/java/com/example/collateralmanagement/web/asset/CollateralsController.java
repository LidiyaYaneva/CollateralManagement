package com.example.collateralmanagement.web.asset;


import com.example.collateralmanagement.models.dtos.asset.CreateCollateralDTO;
import com.example.collateralmanagement.services.CollateralService;
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
@RequestMapping("/creditRiskAssets/collaterals")
public class CollateralsController {

    private final CollateralService collateralService;

    public CollateralsController( CollateralService collateralService) {
        this.collateralService = collateralService;
    }

    @ModelAttribute ("createCollateralDTO")
    public CreateCollateralDTO init(Model model){
        CreateCollateralDTO createCollateralDTO = new CreateCollateralDTO();
        model.addAttribute("createCollateralDTO", createCollateralDTO);
        return createCollateralDTO;
    }

    @GetMapping ("/addCollateralFromAsset")
    public String displayAddCollateralForm (){

        return "addCollateral";
    }

    @PostMapping( "/save")
    public String saveCollateral (@Valid CreateCollateralDTO createCollateralDTO, BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("createCollateralDTO", createCollateralDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.createCollateralDTO", bindingResult);
            return "redirect:/creditRiskAssets/collaterals/addCollateralFromAsset/";
        }
        this.collateralService.addCollateral(createCollateralDTO);
        return "redirect:/creditRiskAssets/collaterals";

    }
}
