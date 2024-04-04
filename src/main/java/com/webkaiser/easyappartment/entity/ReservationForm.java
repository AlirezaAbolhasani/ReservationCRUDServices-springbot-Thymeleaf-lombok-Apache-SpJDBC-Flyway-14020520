package com.webkaiser.easyappartment.entity;

//import lombok.NoArgsConstructor;

import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.io.Serializable;

import static sun.security.x509.PolicyInformation.ID;

//@JsonSerialize
//@Data
//@NoArgsConstructor
public class ReservationForm implements Serializable {
    @Id
    private byte id;
    private String name ;
    private String family;
    private String phoneNumber;
    private String address;
    private String zipcode;
    private String email;

    public ReservationForm(){}

    @Override
    public String toString() {
        return "ReservationForm{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public ReservationForm(byte id, String name, String family, String phoneNumber, String address, String zipcode, String email) {
        this.id = id;
        this.name = name;
        this.family = family;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.zipcode = zipcode;
        this.email = email;
    }

    public byte getId() {
        return id;
    }

    public void setId(byte id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
