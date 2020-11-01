package com.smarthack.sudo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * A UserDto.
 */
public class UserDto {

    private String cnp;

    @NotBlank
    @Pattern(regexp = "^(?>[a-zA-Z0-9!$&*+=?^_`{|}~.-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*)|(?>[_.@A-Za-z0-9-]+)$")
    @Size(min = 1, max = 50)
    private String login;

    @Size(max = 50)
    private String firstName;

    @Size(max = 50)
    private String lastName;

    @Email
    @Size(min = 5, max = 254)
    private String email;

    private boolean activated = false;

    @Size(max = 50)
    private String address;

    @Size(max = 25)
    private String birthdate;

    private boolean edoctor = false;

    public boolean isEdoctor() {
        return edoctor;
    }

    public UserDto setEdoctor(boolean edoctor) {
        this.edoctor = edoctor;
        return this;
    }

    public String getCnp() {
        return cnp;
    }

    public UserDto setCnp(String cnp) {
        this.cnp = cnp;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public UserDto setLogin(String login) {
        this.login = login;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public boolean isActivated() {
        return activated;
    }

    public UserDto setActivated(boolean activated) {
        this.activated = activated;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public UserDto setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public UserDto setBirthdate(String birthdate) {
        this.birthdate = birthdate;
        return this;
    }

    @Override
    public String toString() {
        return "{\"_class\":\"UserDto\", " +
                "\"cnp\":" + (cnp == null ? "null" : "\"" + cnp + "\"") + ", " +
                "\"login\":" + (login == null ? "null" : "\"" + login + "\"") + ", " +
                "\"firstName\":" + (firstName == null ? "null" : "\"" + firstName + "\"") + ", " +
                "\"lastName\":" + (lastName == null ? "null" : "\"" + lastName + "\"") + ", " +
                "\"email\":" + (email == null ? "null" : "\"" + email + "\"") + ", " +
                "\"activated\":\"" + activated + "\"" + ", " +
                "\"address\":" + (address == null ? "null" : "\"" + address + "\"") + ", " +
                "\"birthdate\":" + (birthdate == null ? "null" : "\"" + birthdate + "\"") +
                "}";
    }
}