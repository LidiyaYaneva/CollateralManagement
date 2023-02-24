package com.example.collateralmanagement.web;

import com.example.collateralmanagement.models.dtos.asset.DisplayAcquiredAssetDTO;
import com.example.collateralmanagement.services.AcquiredAssetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final AcquiredAssetService acquiredAssetService;

    public HomeController(AcquiredAssetService acquiredAssetService) {
        this.acquiredAssetService = acquiredAssetService;
    }

    @GetMapping("/")
    public String displayIndex () {

        return "index";
    }

    @GetMapping("/home")
    public String displayHome () {

        return "home";
    }

    @GetMapping("/business")
    public String displayBusinessPage () {

        return "business";
    }

    @GetMapping("/collaterals")
    public String displayCollateralsPage () {

        return "collaterals";
    }

    @GetMapping("/evaluations")
    public String displayEvaluationsPage () {

        return "evaluations";
    }

    @GetMapping("/acquiredAssets")
    public String displayAcquiredAssets (Model model) {

        DisplayAcquiredAssetDTO displayAcquiredAssetDTO = new DisplayAcquiredAssetDTO();
        //List<DisplayAcquiredAssetDTO> displayAcquiredAssetDTO = this.acquiredAssetService.findAllActive();
        model.addAttribute("displayAcquiredAssetDTO", displayAcquiredAssetDTO);

        return "acquiredAssets";
    }

    @GetMapping("/adminPanel")
    public String displayAdminPanel () {

        return "adminPanel";
    }
}
