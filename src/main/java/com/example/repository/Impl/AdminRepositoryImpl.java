package com.example.repository.Impl;

import com.example.entity.Admin;
import com.example.entity.Patient;
import com.example.repository.AdminRepository;
import com.example.utils.JDBCTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminRepositoryImpl implements AdminRepository {
    @Override
    public Admin login(String username, String password) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "select * from Admin where username = ? and password = ?";
        connection = JDBCTools.getConnection();
        Admin admin = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1 , username);
            statement.setString(2 , password);
            resultSet = statement.executeQuery();
            while(resultSet.next()) {
                admin = new Admin(resultSet.getInt(1) ,
                        resultSet.getString(2) ,
                        resultSet.getString(3));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCTools.release(connection , statement , resultSet);
        }
        return admin;
    }

    @Override
    public boolean findByUsername(String username) {
        boolean state = false;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "select * from admin where username = ?";
        connection = JDBCTools.getConnection();
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1 , username);
            resultSet = statement.executeQuery();
            while(resultSet.next()) {
                state = true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCTools.release(connection , statement , null);
        }
        return state;
    }
}
