package com.example.repository.Impl;

import com.example.repository.SignupRepository;
import com.example.utils.JDBCTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SignupRepositoryImpl implements SignupRepository {

    @Override
    public void AddPatient(String username, String password, String name, Integer age, String sex, String address, String phone) {
        Connection connection = null;
        PreparedStatement statement = null;
        String sql = "insert into Patient(Patient_name  , Patient_age , Patient_sex ,Patient_Address , Patient_Phone , username , password ) values( ?, ? , ?  , ?  , ?  , ?  , ? )";
        connection = JDBCTools.getConnection();
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1 , name);
            statement.setInt(2 , age);
            statement.setString(3 , sex);
            statement.setString(4 , address);
            statement.setString(5 , phone);
            statement.setString(6 , username);
            statement.setString(7 , password);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCTools.release(connection , statement , null);
        }
    }
}
