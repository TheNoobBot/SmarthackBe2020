package com.smarthack.sudo.domain;

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
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "orders")
public class Order {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(length = 50)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="prescription_id")
    private Prescription prescription;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="doctor_id")
    private Doctor doctor;

    @OneToMany(
            mappedBy = "order",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<OrderedMedicine> medicineList = new ArrayList<>();

    public String getId() {
        return id;
    }

    public Order setId(String id) {
        this.id = id;
        return this;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public Order setPrescription(Prescription prescription) {
        this.prescription = prescription;
        return this;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Order setDoctor(Doctor doctor) {
        this.doctor = doctor;
        return this;
    }

    public List<OrderedMedicine> getMedicineList() {
        return medicineList;
    }

    public Order setMedicineList(List<OrderedMedicine> medicineList) {
        this.medicineList = medicineList;
        return this;
    }
}
