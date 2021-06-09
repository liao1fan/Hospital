package com.example.repository.Impl;

import com.example.entity.Doctor;
import com.example.entity.Doctor_state;
import com.example.entity.Register;
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
                registerList.add(resultSet.getInt(1),new Register(patientRepository.findById(resultSet.getInt(2)),
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
    public void changeNum(Integer doctorStateId) {
        Connection connection = null;
        PreparedStatement statement = null;
        connection = JDBCTools.getConnection();
        String sql = "update  doctor_state set Num = Num - 1 where Doctor_state_id = ?"; // 挂号数量减1
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1 , doctorStateId);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCTools.release(connection, statement, null);
        }
    }
}
