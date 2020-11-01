package com.smarthack.sudo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * A Patient.
 */
@Entity
@Table(name = "patient")
public class Patient implements Serializable {

    @Id
    @Column(name = "user_cnp")
    private String cnp;

    @Column(name = "health_insurance_id")
    private String healthInsuranceId;

    @ManyToOne
    @JsonIgnore
    private Doctor doctor;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_cnp")
    private User user;

    public User getUser() {
        return user;
    }

    public Patient user(User user) {
        this.user = user;
        return this;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public String getCnp() {
        return cnp;
    }

    public void setCnp(String id) {
        this.cnp = id;
    }

    public String getHealthInsuranceId() {
        return healthInsuranceId;
    }

    public Patient healthInsuranceId(String healthInsuranceId) {
        this.healthInsuranceId = healthInsuranceId;
        return this;
    }

    public void setHealthInsuranceId(String healthInsuranceId) {
        this.healthInsuranceId = healthInsuranceId;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient doctor(Doctor doctor) {
        this.doctor = doctor;
        return this;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Patient)) {
            return false;
        }
        return cnp != null && cnp.equals(((Patient) o).cnp);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Patient{" +
                "id=" + getCnp() +
                ", healthInsuranceId='" + getHealthInsuranceId() + "'" +
                "}";
    }
}
