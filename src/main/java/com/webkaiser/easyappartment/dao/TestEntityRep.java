package com.webkaiser.easyappartment.dao;

import com.webkaiser.easyappartment.entity.EasyAppartment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
//import org.flywaydb.core.internal.jdbc.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TestEntityRep implements TestEntityDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TestEntityRep(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public EasyAppartment selectAPerson(byte id) {
        final String sql="SELECT Name ,Family FROM easyappartment.test WHERE id = ?;";
        List<EasyAppartment> testentityArrayList = new ArrayList<EasyAppartment>();
        EasyAppartment testEntity = jdbcTemplate.queryForObject(sql,new Object[]{id},(resultSet, i)->
        {
            String pName   = resultSet.getString("name");
            String pFamily = resultSet.getString("family");
            return new EasyAppartment(pName,pFamily);
        });
        return testEntity;
    }

    @Override
    public List<EasyAppartment> selectAllUsers() {
        List<EasyAppartment> users = jdbcTemplate.query(
                String.format("SELECT id, Name, Family FROM easyappartment.test; "),
                (Object[]) null,
                (req, rowNum) -> new EasyAppartment(req.getByte("id"),req.getString("name"), req.getString("family")));
        return users;
    }

    // Part Two: you can import data to each section as below sample
    @Override
    public int saveUser(EasyAppartment e){
        String query="insert into easyappartment.test(name ,family) values('"+e.getName()+"','"+e.getFamily()+"')";
        return jdbcTemplate.update(query);
    }
    @Override
    public int updateUser(EasyAppartment e){
        String query="update easyappartment.test set  name='"+e.getName()+"',family='"+e.getFamily()+"' where id='"+e.getId()+"'";
        return jdbcTemplate.update(query);
    }
    @Override
    public int deleteUser(byte id){
        String query="delete from easyappartment.test where id='"+id+"' ";
        return jdbcTemplate.update(query);
    }

}
