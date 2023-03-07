package com.example.collateralmanagement.web.asset;

import com.example.collateralmanagement.models.dtos.asset.DisplayCollateralDTO;
import com.example.collateralmanagement.services.CollateralService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/creditRiskAssets")
public class CreditRiskAssetsController {

    private final CollateralService collateralService;

    public CreditRiskAssetsController(CollateralService collateralService) {
        this.collateralService = collateralService;
    }

    @GetMapping
    public String displayCreditRiskAssetsPage(Model model){

        List<DisplayCollateralDTO> displayCollateralDTOS = this.collateralService.findCollateralsOfRecentLoans();
        model.addAttribute("displayCollateralDTOS", displayCollateralDTOS);

        return "creditRiskAssets";
    }
}
