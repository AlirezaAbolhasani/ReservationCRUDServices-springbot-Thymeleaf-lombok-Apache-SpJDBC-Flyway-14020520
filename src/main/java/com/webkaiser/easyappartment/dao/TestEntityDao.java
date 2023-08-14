package com.webkaiser.easyappartment.dao;

import com.webkaiser.easyappartment.entity.EasyAppartment;

import java.util.List;

public interface TestEntityDao {

    EasyAppartment selectAPerson(byte id);
    List<EasyAppartment> selectAllUsers();
    public int saveUser(EasyAppartment e);
    public int updateUser(EasyAppartment e);
    public int deleteUser(byte id);

}
