package com.webkaiser.easyappartment.dao;

import com.webkaiser.easyappartment.entity.ReservationForm;

import java.util.List;

public interface TestEntityDao {

    ReservationForm selectAReservationForm(String mail);
    List<ReservationForm> selectAllReservationForms();
    public int saveNewForm(ReservationForm e);
    public int updateFormByEmail(ReservationForm e);
    public int deleteAForm(String email);

}
