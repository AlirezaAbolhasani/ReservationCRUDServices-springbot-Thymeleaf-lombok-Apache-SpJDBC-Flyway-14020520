package com.webkaiser.easyappartment.controller;

import com.webkaiser.easyappartment.entity.ReservationForm;
import com.webkaiser.easyappartment.exception.ReservationException;
import com.webkaiser.easyappartment.services.TstServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @RequestMapping(value="/getAllReservationForms",method = RequestMethod.GET)
    public List<ReservationForm> getAllReservationForms ()
    {
        try
        {
           return tstservices.selectAllReservationForms();
        }catch(Exception e)
        {
            e.printStackTrace();
            throw new ReservationException();
        }

    }

//    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @RequestMapping(value = "/selectAReservationForm/{mail}", method = RequestMethod.GET)
    public ReservationForm selectAReservationForm(@PathVariable("mail") String mail){
        try {
            return tstservices.selectAReservationForm(mail);
        }catch (Exception e)
        {
            e.printStackTrace();
            throw new ReservationException();
        }
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
    @RequestMapping(value = "/editeUserInfo/{Email}/{Address}/{PostCode}",
            method = RequestMethod.PUT)
    public int editUserInfo(@PathVariable("Email") String email,
                          @PathVariable("Address") String address,
                          @PathVariable("PostCode") String zipCode){
        ReservationForm reservationForm = new ReservationForm();
        reservationForm.setEmail(email);
        reservationForm.setAddress(address);
        reservationForm.setZipcode(zipCode);

        return tstservices.updateFormByEmail(reservationForm);
    }
    @ExceptionHandler()
    @RequestMapping(value = "/deleteAForm/{Email}",method = RequestMethod.DELETE)
    public int deleteAForm(@PathVariable("Email") String email){
       int a =tstservices.deleteAForm(email);
       throw new ReservationException();
    }

    public void runner(ApplicationArguments arg) {
        System.out.println("*****************************************************************************");
        System.out.println("*****************************************************************************");
        System.out.println("**********************Reservation Webservice Is Running**********************");
        System.out.println("**********************Developer:Alireza Abolhasani***************************");
        System.out.println("*****************************************************************************");
        System.out.println("*****************************************************************************");
    }

}
