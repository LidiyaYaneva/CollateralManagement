package com.example.collateralmanagement.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
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
    public String displayAcquiredAssets () {

        return "acquiredAssets";
    }
}
