package com.example.repository.Impl;

import com.example.entity.Patient;
import com.example.repository.PatientRepository;
import com.example.utils.JDBCTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PatientRepositoryImpl implements PatientRepository {

    @Override
    public Patient login(String username, String password) {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "select * from Patient where username = ? and password = ?";
        connection = JDBCTools.getConnection();
        Patient patient = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1 , username);
            statement.setString(2 , password);
            resultSet = statement.executeQuery();
            while(resultSet.next()) {
                patient = new Patient(resultSet.getInt(1) ,
                        resultSet.getString(2) ,
                        resultSet.getInt(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCTools.release(connection , statement , resultSet);
        }
        return patient;
    }

    @Override
    public boolean findByUsername(String username) {
        boolean state = false;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "select * from patient where username = ?";
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
            JDBCTools.release(connection , statement , resultSet);
        }
        return state;
    }

    @Override
    public List<Patient> findAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "select * from Patient";
        connection = JDBCTools.getConnection();
        List<Patient> patientList = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while(resultSet.next()) {
                patientList.add(new Patient(resultSet.getInt(1) ,
                        resultSet.getString(2) ,
                        resultSet.getInt(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8)));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCTools.release(connection , statement , resultSet);
        }
        return patientList;
    }

    @Override
    public Patient findById(Integer id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "select * from Patient where Patient_id = ?";
        connection = JDBCTools.getConnection();
        Patient patient = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1 , id);
            resultSet = statement.executeQuery();
            while(resultSet.next()) {
                patient = new Patient(resultSet.getInt(1) ,
                        resultSet.getString(2) ,
                        resultSet.getInt(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCTools.release(connection , statement , resultSet);
        }
        return patient;
    }
}
