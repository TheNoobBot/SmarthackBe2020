package com.smarthack.sudo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * A PatientDto.
 */
public class PatientDto extends UserDto {

    private String healthInsuranceId;
    @JsonIgnore
    private DoctorDto doctor;
    private String doctorCnp;

    public String getHealthInsuranceId() {
        return healthInsuranceId;
    }

    public PatientDto setHealthInsuranceId(String healthInsuranceId) {
        this.healthInsuranceId = healthInsuranceId;
        return this;
    }

    public String getDoctorCnp() {
        return doctorCnp;
    }

    public PatientDto setDoctorCnp(String doctorCnp) {
        this.doctorCnp = doctorCnp;
        return this;
    }

    public DoctorDto getDoctor() {
        return doctor;
    }

    public PatientDto setDoctor(DoctorDto doctor) {
        this.doctor = doctor;
        return this;
    }

}
