package com.smarthack.sudo.prescriptions.model.responses;

public class MedicineResponse {

    private String pharmacyId;
    private String resourceId;
    private String title;
    private int inventory;
    private int price;

    public String getPharmacyId() {
        return pharmacyId;
    }

    public MedicineResponse setPharmacyId(String pharmacyId) {
        this.pharmacyId = pharmacyId;
        return this;
    }

    public String getResourceId() {
        return resourceId;
    }

    public MedicineResponse setResourceId(String resourceId) {
        this.resourceId = resourceId;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public MedicineResponse setTitle(String title) {
        this.title = title;
        return this;
    }

    public int getInventory() {
        return inventory;
    }

    public MedicineResponse setInventory(int inventory) {
        this.inventory = inventory;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
