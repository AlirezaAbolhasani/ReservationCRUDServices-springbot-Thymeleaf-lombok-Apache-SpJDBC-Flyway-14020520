package com.webkaiser.easyappartment.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import java.io.Serializable;


//@JsonSerialize
@Data
public class EasyAppartment implements Serializable {

    private byte id;
    private String name;
    private String family;

    public EasyAppartment() {
    }
    public EasyAppartment(String name, String Family){
        this.name= name;
        this.family= family;
    }
    public EasyAppartment(byte id, String name, String family) {
        this.id =id;
        this.name = name;
        this.family = family;
    }

}
