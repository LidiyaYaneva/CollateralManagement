package com.example.collateralmanagement.web;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/")
    public String displayIndex () {

        return "index";
    }

    @GetMapping("/home")
    public String displayHome () {

        return "home";
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
