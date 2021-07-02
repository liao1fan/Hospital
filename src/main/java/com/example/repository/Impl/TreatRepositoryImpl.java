package com.example.repository.Impl;

import com.example.entity.*;
import com.example.repository.DoctorRepository;
import com.example.repository.PatientRepository;
import com.example.repository.TreatRepository;
import com.example.utils.JDBCTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class TreatRepositoryImpl implements TreatRepository {

    private static PatientRepository patientRepository = new PatientRepositoryImpl();

    private static DoctorRepository doctorRepository = new DoctorRepositoryImpl();

    @Override
    public List<Treat> findByDoctorId(Integer doctorId) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Treat> treatList = new ArrayList<>();
        connection = JDBCTools.getConnection();
        String sql = "select * from treat where Doctor_id = ? ";

        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, doctorId );
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                treatList.add(new Treat(resultSet.getInt(1) ,
                        patientRepository.findById(resultSet.getInt(2)),
                        doctorRepository.findByDoctorId(resultSet.getInt(3)),
                        resultSet.getTimestamp(4),
                        resultSet.getString(5),resultSet.getString(6) ));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCTools.release(connection, statement, resultSet);
        }
        return treatList;
    }

    @Override
    public void addTreat(Patient patient, Doctor doctor, java.sql.Timestamp time , String symptom, String diagnose) {
        Connection connection = null;
        PreparedStatement statement = null;
        connection = JDBCTools.getConnection();
        String sql = "insert into treat(Patient_id, Doctor_id, Treat_dateTime ,symptom, Diagnose_info) values( ?, ? , ?, ? , ? );";
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1 , patient.getId());
            statement.setInt(2 , doctor.getId());
            statement.setTimestamp(3 , time);
            statement.setString(4 ,symptom );
            statement.setString(5 , diagnose);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCTools.release(connection, statement, null);
        }
    }

    @Override
    public Treat findById(Integer treatId) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Treat treat = null;
        connection = JDBCTools.getConnection();
        String sql = "select * from treat where Treat_id = ? ";

        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, treatId);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                treat = new Treat(resultSet.getInt(1),
                        patientRepository.findById(resultSet.getInt(2)),
                        doctorRepository.findByDoctorId(resultSet.getInt(3)),
                        resultSet.getTimestamp(4),
                        resultSet.getString(5), resultSet.getString(6)
                       );
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCTools.release(connection, statement, resultSet);
        }
        return treat;
    }

    @Override
    public void updateDiagnose(Integer treatId, String symptom, String diagnose) {
        Connection connection = null;
        PreparedStatement statement = null;
        connection = JDBCTools.getConnection();
        String sql = "update treat set symptom = ? , Diagnose_info = ? where Treat_id = ?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1 , symptom);
            statement.setString(2 , diagnose);
            statement.setInt(3 , treatId);
            statement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCTools.release(connection, statement, null);
        }
    }

    @Override
    public List<Treat> findByPatientId(Integer patientId) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Treat> treatList = new ArrayList<>();
        connection = JDBCTools.getConnection();
        String sql = "select * from treat where Patient_id = ? ";

        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, patientId );
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                treatList.add(new Treat(resultSet.getInt(1) ,
                        patientRepository.findById(resultSet.getInt(2)),
                        doctorRepository.findByDoctorId(resultSet.getInt(3)),
                        resultSet.getTimestamp(4),
                        resultSet.getString(5),resultSet.getString(6) ));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCTools.release(connection, statement, resultSet);
        }
        return treatList;
    }
}
