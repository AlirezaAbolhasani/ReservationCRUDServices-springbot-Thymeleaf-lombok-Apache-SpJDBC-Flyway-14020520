package com.webkaiser.easyappartment.controller;

import com.mysql.cj.x.protobuf.Mysqlx;
import com.webkaiser.easyappartment.alert.Status;
import com.webkaiser.easyappartment.entity.ReservationForm;
import com.webkaiser.easyappartment.exception.ControllerAdviceHandeller;
import com.webkaiser.easyappartment.exception.RunTimeReservationError;
import com.webkaiser.easyappartment.services.TstServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import java.util.Arrays;
import java.util.List;

import static com.webkaiser.easyappartment.alert.Message.SELECT_SUCCESS;
import static com.webkaiser.easyappartment.alert.Status.*;

//@RequestMapping("ReservationForm/")
@RestController
public class ReserveFormInformation {

    private TstServices tstservices;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ReserveFormInformation(TstServices tstservices)
    {
        this.tstservices = tstservices;
    }

//  @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @RequestMapping(value="/getAllReservationForms",method = RequestMethod.GET)
    public ResponseEntity<List<ReservationForm>> getAllReservationForms ()
    {
        return new ResponseEntity<>(tstservices.selectAllReservationForms(), HttpStatus.OK);
    }

    @CrossOrigin(origins = DEFAULT_HOST_NAME)
    @RequestMapping(value = "/selectAReservationForm/{mail}", method = RequestMethod.GET)
    public ResponseEntity<ReservationForm> selectAReservationForm(@PathVariable("mail") String mail/*,@RequestBody String m*/){
        ReservationForm reservationForm;
        //String n = m;
        HttpHeaders headers = null;
        HttpStatus httpStatus = null;
        try {
            reservationForm = tstservices.selectAReservationForm(mail);
            if (!(reservationForm.getId() == 0 )) {
                return ResponseEntity.ok()
                        .header(SELECT_SUCCESS, "200")
                        .body(reservationForm);
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new RunTimeReservationError(HttpStatus.NOT_FOUND,"MSG_ZERO");
        }
//      return  ResponseEntity(reservationForm,headers,httpStatus);
        return  ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(reservationForm);
    }

    private void httpStatus(int i) {
    }

    @PostMapping(value = "/saveNewForm/{Name}/{Family}/{ZipCode}/{PhoneNumber}/{Address}/{Email}")
     public ResponseEntity<Integer> saveNewForm(@PathVariable("Name") String name,
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
        return ResponseEntity.ok().body(tstservices.saveNewForm(reservationForm));

     }

    @RequestMapping(value = "/editeUserInfo/{Email}/{Address}/{PostCode}",
            method = RequestMethod.PUT)
    public ResponseEntity<Integer> editUserInfo(@PathVariable("Email") String email,
                          @PathVariable("Address") String address,
                          @PathVariable("PostCode") String zipCode){

            ReservationForm reservationForm = new ReservationForm();
            reservationForm.setEmail(email);
            reservationForm.setAddress(address);
            reservationForm.setZipcode(zipCode);
            return ResponseEntity.ok().body(tstservices.updateFormByEmail(reservationForm));

    }

    @RequestMapping(value = "/deleteAForm/{Email}",method = RequestMethod.DELETE)
    public ResponseEntity<Integer> deleteAForm(@PathVariable("Email") String email){
        return ResponseEntity.ok().body(tstservices.deleteAForm(email));
    }



}
