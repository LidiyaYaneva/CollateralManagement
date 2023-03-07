package com.example.collateralmanagement.web.valuation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/evaluations")
public class EvaluationController {

    @GetMapping
    public String displayEvaluationsPage () {

        return "evaluations";
    }
}
