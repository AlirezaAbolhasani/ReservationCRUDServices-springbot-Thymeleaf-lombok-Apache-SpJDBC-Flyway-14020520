package com.webkaiser.easyappartment.controller;

import com.webkaiser.easyappartment.entity.ReservationForm;
import com.webkaiser.easyappartment.services.TstServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Email;
import java.util.List;

@RequestMapping("ReservationForm/")
@RestController
public class ReserveFormInformation {

    private TstServices tstservices;

    @Autowired
    private ReserveFormInformation(TstServices tstservices)
    {
        this.tstservices = tstservices;
    }

    @RequestMapping(value="/getAllReservationForms",method = RequestMethod.GET)
    public List<ReservationForm> getAllReservationForms ()
    {
        return tstservices.selectAllReservationForms();
    }

    @RequestMapping(value = "/selectAReservationForm/{mail}", method = RequestMethod.GET)
    public ReservationForm selectAReservationForm(@PathVariable("mail") String mail){
        return tstservices.selectAReservationForm(mail);
    }

    // http://127.0.0.1:8080/Webkaiser/addNewUser/Alireza/Abolhasani
    @PostMapping(value = "/saveNewForm/{Name}/{Family}/{ZipCode}/{PhoneNumber}/{Address}/{Email}")
     public int saveNewForm(@PathVariable("Name") String name,
                            @PathVariable("Family") String family,
                            @PathVariable("ZipCode") String zipcode,
                            @PathVariable("PhoneNumber") String phoneNumber,
                            @PathVariable("Address") String address,
                            @PathVariable("Email") String email){
        ReservationForm reservationForm = new ReservationForm();
        reservationForm.setName(name);
        reservationForm.setFamily(family);
        reservationForm.setZipcode(zipcode);
        reservationForm.setPhoneNumber(phoneNumber);
        reservationForm.setAddress(address);
        reservationForm.setEmail(email);
        return tstservices.saveNewForm(reservationForm);
     }

    // http://localhost:8080/Webkaiser/updateUser?name=100&family=something
    @RequestMapping(value = "/editeUserInfo/{Email}/{Address}/{Zipcode}",
            method = RequestMethod.PUT)
    public int editeUserInfo(@PathVariable("Email") String email,
                          @PathVariable("Address") String address,
                          @PathVariable("ZipCode") String zipCode){
        ReservationForm reservationForm = new ReservationForm();
        reservationForm.setEmail(email);
        reservationForm.setAddress(address);
        reservationForm.setZipcode(zipCode);

        return tstservices.updateFormByEmail(reservationForm);
    }

    @RequestMapping(value = "/deleteAForm/{Email}",method = RequestMethod.DELETE)
    public int deleteAForm(@PathVariable("Email") String email){
        return tstservices.deleteAForm(email);
    }

}
