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



    @GetMapping("/collaterals")
    public String displayCollateralsPage () {

        return "collaterals";
    }

    @GetMapping("/evaluations")
    public String displayEvaluationsPage () {

        return "evaluations";
    }



    @GetMapping("/adminPanel")
    public String displayAdminPanel () {

        return "adminPanel";
    }
}
