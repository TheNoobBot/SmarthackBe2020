package com.smarthack.sudo.prescriptions.model.requests;

public class SearchMedicineRequest {
    private String activeSubstance;
    private String amountOfActiveSubstance;

    public String getActiveSubstance() {
        return activeSubstance;
    }

    public SearchMedicineRequest setActiveSubstance(String activeSubstance) {
        this.activeSubstance = activeSubstance;
        return this;
    }

    public String getAmountOfActiveSubstance() {
        return amountOfActiveSubstance;
    }

    public SearchMedicineRequest setAmountOfActiveSubstance(String amountOfActiveSubstance) {
        this.amountOfActiveSubstance = amountOfActiveSubstance;
        return this;
    }
}
