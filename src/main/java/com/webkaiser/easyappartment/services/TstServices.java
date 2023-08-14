package com.webkaiser.easyappartment.services;

import com.webkaiser.easyappartment.dao.TestEntityDao;
import com.webkaiser.easyappartment.entity.EasyAppartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TstServices {

    private TestEntityDao testEntityDao;

    @Autowired
    public TstServices(TestEntityDao te) {
        this.testEntityDao = te;
    }

    public EasyAppartment selectAPerson(byte id)
    {
        return  testEntityDao.selectAPerson(id);
    }

    public List<EasyAppartment> selectAllUsers()
    {
       return testEntityDao.selectAllUsers();
    }

    public int addNewUser (EasyAppartment easyAppartment){
        return testEntityDao.saveUser(easyAppartment);
    }
    public int updateAnOldUser(EasyAppartment easyAppartment){
        return testEntityDao.updateUser(easyAppartment);
    }
    public int deleteAnUser(byte id){
        return testEntityDao.deleteUser(id);
    }


}
