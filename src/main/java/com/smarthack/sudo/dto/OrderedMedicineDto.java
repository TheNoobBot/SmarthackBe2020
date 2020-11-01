package com.smarthack.sudo.dto;

/**
 * A OrderedMedicine.
 */
public class OrderedMedicineDto  {

    private String id;
    private String resourceId;
    private Integer quantity;
    private Double price;
    private String title;
    private String pharmacyName;

    public String getId() {
        return id;
    }

    public OrderedMedicineDto setId(String id) {
        this.id = id;
        return this;
    }

    public String getResourceId() {
        return resourceId;
    }

    public OrderedMedicineDto setResourceId(String resourceId) {
        this.resourceId = resourceId;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public OrderedMedicineDto setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public OrderedMedicineDto setPrice(Double price) {
        this.price = price;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public OrderedMedicineDto setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getPharmacyName() {
        return pharmacyName;
    }

    public OrderedMedicineDto setPharmacyName(String pharmacyName) {
        this.pharmacyName = pharmacyName;
        return this;
    }
}
