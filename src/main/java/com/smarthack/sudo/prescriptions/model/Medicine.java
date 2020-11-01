package com.smarthack.sudo.prescriptions.model;

import java.io.Serializable;
import java.util.Objects;

public class Medicine implements Serializable {
    private String id;
    private String name;
    private int price;
    private int quantity;
    private String activeSubstance;
    private String concentration;

    public Medicine(String id, String name, int price, int quantity, String activeSubstance, String concentration) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.activeSubstance = activeSubstance;
        this.concentration = concentration;
    }

    public Medicine(String id, String name, int price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Medicine() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getActiveSubstance() {
        return activeSubstance;
    }

    public void setActiveSubstance(String activeSubstance) {
        this.activeSubstance = activeSubstance;
    }

    public String getConcentration() {
        return concentration;
    }

    public void setConcentration(String concentration) {
        this.concentration = concentration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medicine medicine = (Medicine) o;
        return ((Medicine) o).getName().contains(getFirstWord(name));
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstWord(name));
    }

    private String getFirstWord(String text) {
        int index = text.indexOf(' ');
        if (index > -1) { // Check if there is more than one word.
            return text.substring(0, index).trim(); // Extract first word.
        } else {
            return text; // Text is the first word itself.
        }
    }
}
