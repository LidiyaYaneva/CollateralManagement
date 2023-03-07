package com.example.collateralmanagement.services;

import java.io.IOException;

public interface SeedService {

    void seedExampleClients();

    void seedExampleLoans();

    void seedExampleAssets();

    void seedExampleCollaterals();

    void seedExampleAcquiredAssets();

    void seedExampleEvaluations();

    void seedAllExamples();

    void seedAllInitialData() throws IOException;
}
