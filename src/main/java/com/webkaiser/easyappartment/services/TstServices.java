package com.webkaiser.easyappartment.services;

import com.webkaiser.easyappartment.dao.TestEntityDao;
import com.webkaiser.easyappartment.entity.ReservationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TstServices {

    private TestEntityDao testEntityDao;

    @Autowired
    public TstServices(TestEntityDao te) {
        this.testEntityDao = te;
    }

    public ReservationForm selectAReservationForm(String mail)
    {
        return  testEntityDao.selectAReservationForm(mail);
    }

    public List<ReservationForm> selectAllReservationForms()
    {
       return testEntityDao.selectAllReservationForms();
    }

    public int saveNewForm (ReservationForm reservationForm){
        return testEntityDao.saveNewForm(reservationForm);
    }
    public int updateFormByEmail(ReservationForm reservationForm){
        return testEntityDao.updateFormByEmail(reservationForm);
    }
    public int deleteAForm(String mail){
        return testEntityDao.deleteAForm(mail);
    }


}
