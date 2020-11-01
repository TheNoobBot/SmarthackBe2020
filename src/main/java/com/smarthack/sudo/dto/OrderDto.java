package com.smarthack.sudo.dto;

import com.smarthack.sudo.domain.Doctor;
import com.smarthack.sudo.domain.OrderedMedicine;
import com.smarthack.sudo.domain.Prescription;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

public class OrderDto {

    private String id;

    private List<OrderedMedicineDto> medicines = new ArrayList<>();

    public String getId() {
        return id;
    }

    public OrderDto setId(String id) {
        this.id = id;
        return this;
    }

    public List<OrderedMedicineDto> getMedicines() {
        return medicines;
    }

    public OrderDto setMedicines(List<OrderedMedicineDto> medicines) {
        this.medicines = medicines;
        return this;
    }
}
