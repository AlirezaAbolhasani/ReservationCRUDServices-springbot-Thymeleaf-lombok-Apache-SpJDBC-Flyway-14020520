package com.webkaiser.easyappartment.dao;

import com.webkaiser.easyappartment.entity.ReservationForm;

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
    public ReservationForm selectAReservationForm(String email) {
        String emailT = email.trim();
        final String sql="SELECT\n" +
                "  name,\n" +
                "  family,\n" +
                "  zipcode,\n" +
                "  phoneNumber,\n" +
                "  address,\n" +
                "  email,\n" +
                "  id\n" +
                "FROM reserveforminformation where email= ?;";
        List<ReservationForm> testentityArrayList = new ArrayList<ReservationForm>();
        ReservationForm testEntity = jdbcTemplate.queryForObject(sql,new Object[]{emailT},(resultSet, i)->
        {
            String pName   = resultSet.getString("name");
            String pFamily = resultSet.getString("family");
            String pzipcode = resultSet.getString("zipcode");
            String pphoneNumber = resultSet.getString("phoneNumber");
            String paddress = resultSet.getString("address");
            String pemail = resultSet.getString("email");
            byte pid = resultSet.getByte("id");

            return new ReservationForm(pid,pName,pFamily,pphoneNumber,paddress,pzipcode,pemail);
        });
        return testEntity;
    }

    @Override
    public List<ReservationForm> selectAllReservationForms() {
        final String sql="SELECT\n" +
                "  name,\n" +
                "  family,\n" +
                "  zipcode,\n" +
                "  phoneNumber,\n" +
                "  address,\n" +
                "  email,\n" +
                "  id\n" +
                "FROM reserveforminformation ;";
        List<ReservationForm> allreserveForms = jdbcTemplate.query(
                String.format(sql),
                (Object[]) null,
                (req, rowNum) -> new ReservationForm(req.getByte("id"),req.getString("name"), req.getString("family"),
                 req.getString("zipcode"),req.getString("phoneNumber"),req.getString("address"),req.getString("email")));
        return allreserveForms;
    }

    // Part Two: you can import data to each section as below sample
    @Override
    public int saveNewForm(ReservationForm e){
        String query="insert into easyappartment.reserveforminformation( name,family,zipcode,phoneNumber,address,email,id) " +
                " values('"+e.getName()+"','"+e.getFamily()+"','"+e.getZipcode()+"'" +
                ",'"+e.getPhoneNumber()+"','"+e.getAddress()+"','"+e.getEmail()+"','"+e.getId()+"')";
        return jdbcTemplate.update(query);
    }
    @Override
    public int updateFormByEmail(ReservationForm e){
        String query="update easyappartment.reserveforminformation set  address='"+e.getAddress()+"',zipcode='"+e.getZipcode()+"' where email='"+e.getEmail()+"'";
        return jdbcTemplate.update(query);
    }
    @Override
    public int deleteAForm(String email){
        String query="delete from easyappartment.reserveforminformation where email='"+email+"' ";
        return jdbcTemplate.update(query);
    }

}
