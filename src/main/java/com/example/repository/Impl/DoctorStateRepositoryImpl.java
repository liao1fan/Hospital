package com.example.repository.Impl;

import com.example.entity.Doctor;
import com.example.entity.Doctor_state;
import com.example.repository.DoctorStateRepository;
import com.example.utils.JDBCTools;

import javax.print.Doc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoctorStateRepositoryImpl implements DoctorStateRepository {

    @Override
    public List<Doctor_state> findAllDateByDepartmentId(Integer departmentid) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Doctor_state> doctorStateList = new ArrayList<>();
        connection = JDBCTools.getConnection();
        String sql = "select * from doctor_state where Doctor_id = ?";

        PreparedStatement statement1 = null;
        ResultSet resultSet1 = null;
        String sql1 = "select Doctor_id , Doctor_name , Doctor_title , Doctor_speciality from Doctor where Doctor_id = ?";

        try {


            statement = connection.prepareStatement(sql);
            statement.setInt(1, departmentid);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                statement1 = connection.prepareStatement(sql1);
                statement1.setInt(1, departmentid);
                resultSet1 = statement1.executeQuery();
                while (resultSet1.next()) {
                    if (resultSet1.getInt(1) == resultSet.getInt(2)) {
                        doctorStateList.add(new Doctor_state(resultSet.getInt(1), new Doctor(resultSet1.getInt(1), resultSet1.getString(2), resultSet1.getString(3), resultSet1.getString(4)), resultSet.getDate(3),
                                resultSet.getDouble(4), resultSet.getInt(5)));
                    }
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCTools.release(connection, statement, resultSet);
        }
        return doctorStateList;
    }

    @Override
    public Doctor_state findByDoctorStateId(Integer doctorStateId) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Doctor_state doctor_state = null;
        connection = JDBCTools.getConnection();
        String sql = "select * from doctor_state where Doctor_state_id = ? ";

        PreparedStatement statement1 = null;
        ResultSet resultSet1 = null;
        String sql1 = "select Doctor_id , Doctor_name , Doctor_title , Doctor_speciality from Doctor where Doctor_id = ?";

        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, doctorStateId);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                statement1 = connection.prepareStatement(sql1);
                statement1.setInt(1, resultSet.getInt(2));
                resultSet1 =statement1.executeQuery();
                while (resultSet1.next()) {
                    doctor_state = new Doctor_state(resultSet.getInt(1), new Doctor(resultSet1.getInt(1), resultSet1.getString(2), resultSet1.getString(3), resultSet1.getString(4)), resultSet.getDate(3),
                            resultSet.getDouble(4), resultSet.getInt(5));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCTools.release(connection, statement, resultSet);
        }
        return doctor_state;
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
