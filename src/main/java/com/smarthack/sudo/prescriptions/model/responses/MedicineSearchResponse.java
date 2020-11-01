package com.smarthack.sudo.prescriptions.model.responses;

import java.util.List;

public class MedicineSearchResponse {
    private List<SearchMedicineResponse> searchMedicineResponses;

    public List<SearchMedicineResponse> getSearchMedicineResponses() {
        return searchMedicineResponses;
    }

    public MedicineSearchResponse setSearchMedicineResponse(List<SearchMedicineResponse> searchMedicineResponses) {
        this.searchMedicineResponses = searchMedicineResponses;
        return this;
    }
}
