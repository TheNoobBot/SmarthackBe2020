package com.smarthack.sudo.prescriptions.model.responses;

import java.util.List;

public class SearchMedicineResponse {
    private String activeSubstance;
    private String amountOfActiveSubstance;
    private List<MedicineResponse> medicineResponses;

    public String getActiveSubstance() {
        return activeSubstance;
    }

    public SearchMedicineResponse setActiveSubstance(String activeSubstance) {
        this.activeSubstance = activeSubstance;
        return this;
    }

    public String getAmountOfActiveSubstance() {
        return amountOfActiveSubstance;
    }

    public SearchMedicineResponse setAmountOfActiveSubstance(String amountOfActiveSubstance) {
        this.amountOfActiveSubstance = amountOfActiveSubstance;
        return this;
    }

    public List<MedicineResponse> getMedicines() {
        return medicineResponses;
    }

    public SearchMedicineResponse setMedicines(List<MedicineResponse> medicineResponses) {
        this.medicineResponses = medicineResponses;
        return this;
    }
}
