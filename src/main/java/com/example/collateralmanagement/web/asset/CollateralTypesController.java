package com.example.collateralmanagement.web.asset;

import com.example.collateralmanagement.models.dtos.asset.CollateralTypeDTO;
import com.example.collateralmanagement.services.CollateralTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/creditRiskAssets/collateralTypes/collateralCategorization")
public class CollateralTypesController {

    private final CollateralTypeService collateralTypeService;

    public CollateralTypesController(CollateralTypeService collateralTypeService) {
        this.collateralTypeService = collateralTypeService;
    }

    @GetMapping
    public String displayCollateralTypes(Model model){

        List<CollateralTypeDTO> collateralTypeDTO = this.collateralTypeService.getCollateralTypesInfo();
        model.addAttribute("collateralTypeDTO", collateralTypeDTO);

        return "collateralCategorization";
    }
}
