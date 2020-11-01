package com.smarthack.sudo.dto;

import com.smarthack.sudo.domain.enumeration.PrescriptionStatus;

import java.io.Serializable;
import java.time.ZonedDateTime;

/**
 * A PrescriptionDto.
 */
public class PrescriptionDto {

    private String id;
    private String location;
    private String diagnostic;
    private String recipeNumber;
    private ZonedDateTime timestamp;
    private ZonedDateTime firstDelivery;
    private Integer recurrencyTime;
    private Boolean permanent;
    private Integer recurrencyCount;
    private Integer deliveredCount = 0;
    private PrescriptionStatus status;
    private Boolean insured;
    private String items;
    private String patientCnp;

    public String getItems() {
        return items;
    }

    public PrescriptionDto setItems(String items) {
        this.items = items;
        return this;
    }

    public String getId() {
        return id;
    }

    public PrescriptionDto setId(String id) {
        this.id = id;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public PrescriptionDto setLocation(String location) {
        this.location = location;
        return this;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public PrescriptionDto setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
        return this;
    }

    public String getRecipeNumber() {
        return recipeNumber;
    }

    public PrescriptionDto setRecipeNumber(String recipeNumber) {
        this.recipeNumber = recipeNumber;
        return this;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public PrescriptionDto setTimestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public ZonedDateTime getFirstDelivery() {
        return firstDelivery;
    }

    public PrescriptionDto setFirstDelivery(ZonedDateTime firstDelivery) {
        this.firstDelivery = firstDelivery;
        return this;
    }

    public Integer getRecurrencyTime() {
        return recurrencyTime;
    }

    public PrescriptionDto setRecurrencyTime(Integer recurrencyTime) {
        this.recurrencyTime = recurrencyTime;
        return this;
    }

    public Boolean getPermanent() {
        return permanent;
    }

    public PrescriptionDto setPermanent(Boolean permanent) {
        this.permanent = permanent;
        return this;
    }

    public Integer getRecurrencyCount() {
        return recurrencyCount;
    }

    public PrescriptionDto setRecurrencyCount(Integer recurrencyCount) {
        this.recurrencyCount = recurrencyCount;
        return this;
    }

    public Integer getDeliveredCount() {
        return deliveredCount;
    }

    public PrescriptionDto setDeliveredCount(Integer deliveredCount) {
        this.deliveredCount = deliveredCount;
        return this;
    }

    public PrescriptionStatus getStatus() {
        return status;
    }

    public PrescriptionDto setStatus(PrescriptionStatus status) {
        this.status = status;
        return this;
    }

    public Boolean getInsured() {
        return insured;
    }

    public PrescriptionDto setInsured(Boolean insured) {
        this.insured = insured;
        return this;
    }

    public String getPatientCnp() {
        return patientCnp;
    }

    public PrescriptionDto setPatientCnp(String patientCnp) {
        this.patientCnp = patientCnp;
        return this;
    }
}