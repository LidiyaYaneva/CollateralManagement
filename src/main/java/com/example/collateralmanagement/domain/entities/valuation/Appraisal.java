package com.example.collateralmanagement.domain.entities.valuation;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue(value = "APPRAISAL")
public class Appraisal extends Evaluation {

    private static final String EVALUATION_TYPE = "APPRAISAL";

    @ManyToOne
    @JoinColumn(name = "appraisal_company_id", referencedColumnName = "id")
    private AppraisalCompany appraisalCompany;

    @Column(nullable = false)
    private String appraiser;

    @Column(name = "valuation_Reviewer")
    private String valuationReviewer;

    @Column (name = "reviewer_opinion")
    private String reviewerOpinion;

    @OneToOne
    @JoinColumn(name = "method_details_id", referencedColumnName = "id")
    private ValuationMethodsDetails valuationMethodsDetails;

    public Appraisal(){
        super(EVALUATION_TYPE);
    }

    public AppraisalCompany getAppraisalCompany() {
        return appraisalCompany;
    }

    public void setAppraisalCompany(AppraisalCompany appraisalCompany) {
        this.appraisalCompany = appraisalCompany;
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

    public ValuationMethodsDetails getValuationMethodsDetails() {
        return valuationMethodsDetails;
    }

    public void setValuationMethodsDetails(ValuationMethodsDetails valuationMethodsDetails) {
        this.valuationMethodsDetails = valuationMethodsDetails;
    }
}
