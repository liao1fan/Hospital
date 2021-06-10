package com.example.repository.Impl;

import com.example.entity.*;
import com.example.repository.DoctorRepository;
import com.example.repository.PatientRepository;
import com.example.repository.RegisterRepository;
import com.example.utils.JDBCTools;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class RegisterRepositoryImpl implements RegisterRepository {

    private static PatientRepository patientRepository = new PatientRepositoryImpl();

    private static DoctorRepository doctorRepository = new DoctorRepositoryImpl();

    @Override
    public void addRegister(Integer patientId, Integer doctorId, Date time, Double fee , Integer state) {
        Connection connection = null;
        PreparedStatement statement = null;
        connection = JDBCTools.getConnection();
        String sql = "insert into register (Patient_id, Doctor_id,  Register_time, Register_fee , Register_state) values(? ,? ,? , ? ,? )";
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1 , patientId);
            statement.setInt(2 , doctorId);
            statement.setDate(3 , (java.sql.Date)time);
            statement.setDouble(4 , fee);
            statement.setInt(5 , state);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCTools.release(connection, statement, null);
        }
    }

    @Override
    public List<Register> findByDoctorId(Integer doctorId) {
        Connection connection = null;
        PreparedStatement statement = null;
        connection = JDBCTools.getConnection();
        List<Register> registerList = new ArrayList<>();
        String sql = "select * from Register where Doctor_id = ?";
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1 , doctorId);
            resultSet = statement.executeQuery();
            while(resultSet.next()) {
                registerList.add(
                        new Register(resultSet.getInt(1) ,  patientRepository.findById(resultSet.getInt(2)),
                                doctorRepository.findByDoctorId(resultSet.getInt(3)), resultSet.getDate(4),
                                resultSet.getDouble(5),resultSet.getInt(6)));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCTools.release(connection, statement, resultSet);
        }
        return registerList;
    }



    @Override
    public void changeState(Integer registerId, Integer state) {
        Connection connection = null;
        PreparedStatement statement = null;
        connection = JDBCTools.getConnection();
        String sql = "update register set Register_state = ? where Register_id = ?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1 , state);
            statement.setInt(2 , registerId);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCTools.release(connection, statement, null);
        }
    }

    @Override
    public Register findById(Integer registerId) {
        Connection connection = null;
        PreparedStatement statement = null;
        connection = JDBCTools.getConnection();
        Register register = null;
        String sql = "select * from Register where Register_id = ?";
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1 , registerId);
            resultSet = statement.executeQuery();
            while(resultSet.next()) {
                register = new Register(resultSet.getInt(1) ,  patientRepository.findById(resultSet.getInt(2)),
                        doctorRepository.findByDoctorId(resultSet.getInt(3)), resultSet.getDate(4),
                        resultSet.getDouble(5),resultSet.getInt(6));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCTools.release(connection, statement, resultSet);
        }
        return register;
    }


}
