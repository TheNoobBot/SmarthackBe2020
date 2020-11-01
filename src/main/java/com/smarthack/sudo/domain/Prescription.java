package com.smarthack.sudo.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.smarthack.sudo.domain.enumeration.PrescriptionStatus;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.List;

/**
 * A Prescription.
 */
@Entity
@Table(name = "prescription")
public class Prescription implements Serializable {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(length = 50)
    private String id;

    @Column(name = "location")
    private String location;

    @Column(name = "diagnostic")
    private String diagnostic;

    @Column(name = "recipe_number")
    private String recipeNumber;

    @Column(name = "timestamp")
    private ZonedDateTime timestamp;

    @Column(name = "first_delivery")
    private ZonedDateTime firstDelivery;

    @Column(name = "recurrency_time")
    private Integer recurrencyTime;

    @Column(name = "permanent")
    private Boolean permanent;

    @Column(name = "recurrency_count")
    private Integer recurrencyCount;

    @Column(name = "delivered_count")
    private Integer deliveredCount;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private PrescriptionStatus status;

    @Column(name = "insured")
    private Boolean insured;

    @OneToMany(mappedBy = "prescription", orphanRemoval = true)
    private List<Order> orders;

    @ManyToOne
    @JsonIgnoreProperties(value = "prescriptions", allowSetters = true)
    private Patient patient;

    public Boolean getPermanent() {
        return permanent;
    }

    public Boolean getInsured() {
        return insured;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public Prescription setOrders(List<Order> orders) {
        this.orders = orders;
        return this;
    }

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public Prescription location(String location) {
        this.location = location;
        return this;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public Prescription diagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
        return this;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public String getRecipeNumber() {
        return recipeNumber;
    }

    public Prescription recipeNumber(String recipeNumber) {
        this.recipeNumber = recipeNumber;
        return this;
    }

    public void setRecipeNumber(String recipeNumber) {
        this.recipeNumber = recipeNumber;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public Prescription timestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public void setTimestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public ZonedDateTime getFirstDelivery() {
        return firstDelivery;
    }

    public Prescription firstDelivery(ZonedDateTime firstDelivery) {
        this.firstDelivery = firstDelivery;
        return this;
    }

    public void setFirstDelivery(ZonedDateTime firstDelivery) {
        this.firstDelivery = firstDelivery;
    }

    public Integer getRecurrencyTime() {
        return recurrencyTime;
    }

    public Prescription recurrencyTime(Integer recurrencyTime) {
        this.recurrencyTime = recurrencyTime;
        return this;
    }

    public void setRecurrencyTime(Integer recurrencyTime) {
        this.recurrencyTime = recurrencyTime;
    }

    public Boolean isPermanent() {
        return permanent;
    }

    public Prescription permanent(Boolean permanent) {
        this.permanent = permanent;
        return this;
    }

    public void setPermanent(Boolean permanent) {
        this.permanent = permanent;
    }

    public Integer getRecurrencyCount() {
        return recurrencyCount;
    }

    public Prescription recurrencyCount(Integer recurrencyCount) {
        this.recurrencyCount = recurrencyCount;
        return this;
    }

    public void setRecurrencyCount(Integer recurrencyCount) {
        this.recurrencyCount = recurrencyCount;
    }

    public Integer getDeliveredCount() {
        return deliveredCount;
    }

    public Prescription deliveredCount(Integer deliveredCount) {
        this.deliveredCount = deliveredCount;
        return this;
    }

    public void setDeliveredCount(Integer deliveredCount) {
        this.deliveredCount = deliveredCount;
    }

    public PrescriptionStatus getStatus() {
        return status;
    }

    public Prescription status(PrescriptionStatus status) {
        this.status = status;
        return this;
    }

    public void setStatus(PrescriptionStatus status) {
        this.status = status;
    }

    public Boolean isInsured() {
        return insured;
    }

    public Prescription insured(Boolean insured) {
        this.insured = insured;
        return this;
    }

    public void setInsured(Boolean insured) {
        this.insured = insured;
    }

    public Patient getPatient() {
        return patient;
    }

    public Prescription patient(Patient patient) {
        this.patient = patient;
        return this;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Prescription)) {
            return false;
        }
        return id != null && id.equals(((Prescription) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Prescription{" +
            "id=" + getId() +
            ", location='" + getLocation() + "'" +
            ", diagnostic='" + getDiagnostic() + "'" +
            ", recipeNumber='" + getRecipeNumber() + "'" +
            ", timestamp='" + getTimestamp() + "'" +
            ", firstDelivery='" + getFirstDelivery() + "'" +
            ", recurrencyTime=" + getRecurrencyTime() +
            ", permanent='" + isPermanent() + "'" +
            ", recurrencyCount=" + getRecurrencyCount() +
            ", deliveredCount=" + getDeliveredCount() +
            ", status='" + getStatus() + "'" +
            ", insured='" + isInsured() + "'" +
            "}";
    }
}
