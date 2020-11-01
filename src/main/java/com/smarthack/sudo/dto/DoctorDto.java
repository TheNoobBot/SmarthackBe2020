package com.smarthack.sudo.dto;

import com.smarthack.sudo.domain.enumeration.DoctorStatus;

import java.util.List;

/**
 * A Doctor.
 */
public class DoctorDto extends UserDto {

    private String pic;
    private DoctorStatus status;
    private UserDto user;
    private List<PatientDto> patients;

    public String getPic() {
        return pic;
    }

    public DoctorDto setPic(String pic) {
        this.pic = pic;
        return this;
    }

    public DoctorStatus getStatus() {
        return status;
    }

    public DoctorDto setStatus(DoctorStatus status) {
        this.status = status;
        return this;
    }

    public UserDto getUser() {
        return user;
    }

    public DoctorDto setUser(UserDto user) {
        this.user = user;
        return this;
    }

    public List<PatientDto> getPatients() {
        return patients;
    }

    public DoctorDto setPatients(List<PatientDto> patients) {
        this.patients = patients;
        return this;
    }
}
