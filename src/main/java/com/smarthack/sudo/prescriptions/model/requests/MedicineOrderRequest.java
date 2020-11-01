package com.smarthack.sudo.prescriptions.model.requests;

public class MedicineOrderRequest {
    private String pharmacyId;
    private String resourceId;
    private String inventory;

    public String getPharmacyId() {
        return pharmacyId;
    }

    public MedicineOrderRequest setPharmacyId(String pharmacyId) {
        this.pharmacyId = pharmacyId;
        return this;
    }

    public String getResourceId() {
        return resourceId;
    }

    public MedicineOrderRequest setResourceId(String resourceId) {
        this.resourceId = resourceId;
        return this;
    }

    public String getInventory() {
        return inventory;
    }

    public MedicineOrderRequest setInventory(String inventory) {
        this.inventory = inventory;
        return this;
    }
}
