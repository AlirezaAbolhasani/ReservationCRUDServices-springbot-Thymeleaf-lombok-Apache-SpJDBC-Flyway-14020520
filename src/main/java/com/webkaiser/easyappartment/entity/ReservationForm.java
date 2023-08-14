package com.webkaiser.easyappartment.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.persistence.*;

//@JsonSerialize
@Data
@NoArgsConstructor
@Table(name = "reserveforminformation")
public class ReservationForm implements Serializable {

    private byte id;
    private String name;
    private String family;
    private String phoneNumber;
    private String address;
    private String zipcode;
    private String email;

    public ReservationForm(byte id, String name, String family, String phoneNumber, String address, String zipcode, String email) {
        this.id = id;
        this.name = name;
        this.family = family;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.zipcode = zipcode;
        this.email = email;
    }
}
