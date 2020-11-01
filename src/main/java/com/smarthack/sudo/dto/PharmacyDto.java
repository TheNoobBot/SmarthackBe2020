package com.smarthack.sudo.dto;


/**
 * A PharmacyDto.
 */
public class PharmacyDto {

    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String salesChannel;
    private String cui;
    private String phoneNumber;
    private String email;
    private String city;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public PharmacyDto setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public PharmacyDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getSalesChannel() {
        return salesChannel;
    }

    public PharmacyDto setSalesChannel(String salesChannel) {
        this.salesChannel = salesChannel;
        return this;
    }

    public String getCui() {
        return cui;
    }

    public PharmacyDto setCui(String cui) {
        this.cui = cui;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public PharmacyDto setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public PharmacyDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getCity() {
        return city;
    }

    public PharmacyDto setCity(String city) {
        this.city = city;
        return this;
    }

    @Override
    public String toString() {
        return "{\"_class\":\"PharmacyDto\", " +
                "\"id\":" + (id == null ? "null" : "\"" + id + "\"") + ", " +
                "\"name\":" + (name == null ? "null" : "\"" + name + "\"") + ", " +
                "\"salesChannel\":" + (salesChannel == null ? "null" : "\"" + salesChannel + "\"") + ", " +
                "\"cui\":" + (cui == null ? "null" : "\"" + cui + "\"") + ", " +
                "\"phoneNumber\":" + (phoneNumber == null ? "null" : "\"" + phoneNumber + "\"") + ", " +
                "\"email\":" + (email == null ? "null" : "\"" + email + "\"") + ", " +
                "\"city\":" + (city == null ? "null" : "\"" + city + "\"") +
                "}";
    }
}
