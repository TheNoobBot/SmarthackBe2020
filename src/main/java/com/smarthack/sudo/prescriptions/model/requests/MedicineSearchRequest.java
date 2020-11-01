package com.smarthack.sudo.prescriptions.model.requests;

import java.util.List;

public class MedicineSearchRequest{
    private List<SearchMedicineRequest> preSearchedMedicines;

    public List<SearchMedicineRequest> getPreSearchedMedicines() {
        return preSearchedMedicines;
    }

    public MedicineSearchRequest setPreSearchedMedicines(List<SearchMedicineRequest> preSearchedMedicines) {
        this.preSearchedMedicines = preSearchedMedicines;
        return this;
    }
}
