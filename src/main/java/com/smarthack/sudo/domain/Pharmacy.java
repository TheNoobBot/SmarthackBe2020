package com.smarthack.sudo.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * A Pharmacy.
 */
@Entity
@Table(name = "pharmacy")
public class Pharmacy implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(length = 50)
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "sales_channel")
    private String salesChannel;

    @Column(name = "cui")
    private String cui;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "city")
    private String city;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Pharmacy name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalesChannel() {
        return salesChannel;
    }

    public Pharmacy salesChannel(String salesChannel) {
        this.salesChannel = salesChannel;
        return this;
    }

    public void setSalesChannel(String salesChannel) {
        this.salesChannel = salesChannel;
    }

    public String getCui() {
        return cui;
    }

    public Pharmacy cui(String cui) {
        this.cui = cui;
        return this;
    }

    public void setCui(String cui) {
        this.cui = cui;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Pharmacy phoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public Pharmacy email(String email) {
        this.email = email;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public Pharmacy city(String city) {
        this.city = city;
        return this;
    }

    public void setCity(String city) {
        this.city = city;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Pharmacy)) {
            return false;
        }
        return id != null && id.equals(((Pharmacy) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Pharmacy{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", salesChannel='" + getSalesChannel() + "'" +
            ", cui='" + getCui() + "'" +
            ", phoneNumber='" + getPhoneNumber() + "'" +
            ", email='" + getEmail() + "'" +
            ", city='" + getCity() + "'" +
            "}";
    }
}
