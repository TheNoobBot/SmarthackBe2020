package com.smarthack.sudo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.smarthack.sudo.domain.enumeration.DoctorStatus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * A Doctor.
 */
@Entity
@Table(name = "doctor")
public class Doctor implements Serializable {

    @Id
    @Column(name = "user_cnp")
    private String cnp;

    @Column(name = "pic")
    private String pic;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private DoctorStatus status;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_cnp")
    private User user;

    @OneToMany(mappedBy = "doctor", orphanRemoval = true)
    @JsonIgnore
    private List<Patient> patients = new ArrayList<>();

    @OneToMany(mappedBy = "doctor", orphanRemoval = true)
    @JsonIgnore
    private List<Order> orders = new ArrayList<>();

    public List<Order> getOrders() {
        return orders;
    }

    public Doctor setOrders(List<Order> orders) {
        this.orders = orders;
        return this;
    }

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public String getCnp() {
        return cnp;
    }

    public void setCnp(String id) {
        this.cnp = id;
    }

    public String getPic() {
        return pic;
    }

    public Doctor pic(String pic) {
        this.pic = pic;
        return this;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public DoctorStatus getStatus() {
        return status;
    }

    public Doctor status(DoctorStatus status) {
        this.status = status;
        return this;
    }

    public void setStatus(DoctorStatus status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public Doctor user(User user) {
        this.user = user;
        return this;
    }

    public void setUser(User user) {
        this.user = user;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Doctor)) {
            return false;
        }
        return cnp != null && cnp.equals(((Doctor) o).cnp);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + getCnp() +
                ", pic='" + getPic() + "'" +
                ", status='" + getStatus() + "'" +
                "}";
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public Doctor setPatients(List<Patient> patients) {
        this.patients = patients;
        return this;
    }
}
