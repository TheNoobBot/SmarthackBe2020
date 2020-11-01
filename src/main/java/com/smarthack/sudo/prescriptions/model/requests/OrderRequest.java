package com.smarthack.sudo.prescriptions.model.requests;

import java.util.List;

public class OrderRequest {
    private String address;
    private String name;
    private String phoneNumber;
    private String email;
    private List<MedicineOrderRequest> medicineOrderRequests;

    public String getAddress() {
        return address;
    }

    public OrderRequest setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getName() {
        return name;
    }

    public OrderRequest setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public OrderRequest setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public OrderRequest setEmail(String email) {
        this.email = email;
        return this;
    }

    public List<MedicineOrderRequest> getMedicineOrders() {
        return medicineOrderRequests;
    }

    public OrderRequest setMedicineOrders(List<MedicineOrderRequest> medicineOrderRequests) {
        this.medicineOrderRequests = medicineOrderRequests;
        return this;
    }
}
