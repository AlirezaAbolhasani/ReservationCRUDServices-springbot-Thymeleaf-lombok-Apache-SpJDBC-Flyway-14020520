package com.webkaiser.easyappartment.controller;

import com.webkaiser.easyappartment.entity.EasyAppartment;
import com.webkaiser.easyappartment.services.TstServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.util.List;

@RequestMapping("Webkaiser")
@RestController
public class TstController {

    private TstServices tstservices;

    @Autowired
    private TstController(TstServices tstservices)
    {
        this.tstservices = tstservices;
    }

    @RequestMapping(value="/getAllUsers",method = RequestMethod.GET)
    public List<EasyAppartment> getAllUsers ()
    {

        return tstservices.selectAllUsers();
    }

    @RequestMapping(value = "/getAUser", method = RequestMethod.GET)
    public EasyAppartment getAUser(byte id){
        return tstservices.selectAPerson(id);
    }

    // http://127.0.0.1:8080/Webkaiser/addNewUser/Alireza/Abolhasani
    @PostMapping(value = "/addNewUser/{Name}/{Family}")
     public int addNewUser(@PathVariable("Name") String name,@PathVariable("Family") String family){
         EasyAppartment easyAppartment = new EasyAppartment();
         easyAppartment.setName(name);
         easyAppartment.setFamily(family);
         return tstservices.addNewUser(easyAppartment);
     }

    // http://localhost:8080/Webkaiser/updateUser?name=100&family=something
    @RequestMapping(value = "/updateUser/{Id}/{Name}/{Family}",
            method = RequestMethod.PUT)
    public int updateUser(@PathVariable("Id") byte id,@PathVariable("Name") String name,@PathVariable("Family") String family){
        EasyAppartment easyAppartment = new EasyAppartment();
        easyAppartment.setId(id);
        easyAppartment.setName(name);
        easyAppartment.setFamily(family);
        return tstservices.updateAnOldUser(easyAppartment);
    }

    @RequestMapping(value = "/deleteUser",method = RequestMethod.DELETE)
    public int deleteUser(byte id){
        return tstservices.deleteAnUser(id);
    }

}
