package com.example.collateralmanagement.models.dtos.valuation;

import java.time.LocalDate;

//TODO decide how the user will enter all the information
public class AddAppraisalDTO {

    private Long assetId;

    private LocalDate date;

    private Double marketValue;

    private Double collateralValue;

    private Long appraisalCompanyId;

    private String appraiser;

    private String valuationReviewer;

    private String reviewerOpinion;

    private Long valuationMethodsDetails;

    public AddAppraisalDTO() {
    }

    public AddAppraisalDTO(Long asset, LocalDate date, Double marketValue, Double collateralValue,
                           Long appraisalCompany, String appraiser, String valuationReviewer,
                           String reviewerOpinion, Long valuationMethodsDetails) {
        this.assetId = asset;
        this.date = date;
        this.marketValue = marketValue;
        this.collateralValue = collateralValue;
        this.appraisalCompanyId = appraisalCompany;
        this.appraiser = appraiser;
        this.valuationReviewer = valuationReviewer;
        this.reviewerOpinion = reviewerOpinion;
        this.valuationMethodsDetails = valuationMethodsDetails;
    }

    public Long getAssetId() {
        return assetId;
    }

    public void setAssetId(Long assetId) {
        this.assetId = assetId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(Double marketValue) {
        this.marketValue = marketValue;
    }

    public Double getCollateralValue() {
        return collateralValue;
    }

    public void setCollateralValue(Double collateralValue) {
        this.collateralValue = collateralValue;
    }

    public Long getAppraisalCompany() {
        return appraisalCompanyId;
    }

    public void setAppraisalCompany(Long appraisalCompany) {
        this.appraisalCompanyId = appraisalCompany;
    }

    public String getAppraiser() {
        return appraiser;
    }

    public void setAppraiser(String appraiser) {
        this.appraiser = appraiser;
    }

    public String getValuationReviewer() {
        return valuationReviewer;
    }

    public void setValuationReviewer(String valuationReviewer) {
        this.valuationReviewer = valuationReviewer;
    }

    public String getReviewerOpinion() {
        return reviewerOpinion;
    }

    public void setReviewerOpinion(String reviewerOpinion) {
        this.reviewerOpinion = reviewerOpinion;
    }

    public Long getValuationMethodsDetails() {
        return valuationMethodsDetails;
    }

    public void setValuationMethodsDetails(Long valuationMethodsDetails) {
        this.valuationMethodsDetails = valuationMethodsDetails;
    }
}
