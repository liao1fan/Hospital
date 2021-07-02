package com.example.repository.Impl;

import com.example.entity.Department;
import com.example.entity.Doctor;
import com.example.entity.Patient;
import com.example.repository.DepartmentRepository;
import com.example.repository.DoctorRepository;
import com.example.utils.JDBCTools;

import javax.print.Doc;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoctorRepositoryImpl implements DoctorRepository {
    private DepartmentRepository departmentRepository = new DepartmentRepositoryImpl();
    @Override
    public Doctor findByDoctorId(Integer doctorId) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "select * from Doctor where Doctor_id = ?";
        connection = JDBCTools.getConnection();
        Doctor doctor = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1 , doctorId);
            resultSet = statement.executeQuery();
            while(resultSet.next()) {
                Department department = departmentRepository.findByDepartmentId(resultSet.getInt(7));
                doctor = new Doctor(resultSet.getInt(1) ,// id
                        resultSet.getString(2) , //name
                        resultSet.getInt(3),//age
                        resultSet.getString(4),//sex
                        resultSet.getString(5) , //title
                        resultSet.getString(6) , // speciality
                        department , // department
                        resultSet.getString(8) , // username
                        resultSet.getString(9)   // password
                );
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCTools.release(connection , statement , resultSet);
        }
        return doctor;
    }

    @Override
    public List<Doctor> findByDepartmentId(Integer departmentId) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "select * from Doctor where Department_id = ?";
        connection = JDBCTools.getConnection();
        Doctor doctor = null;
        List<Doctor> doctorList = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);

            statement.setInt(1 , departmentId);
            resultSet = statement.executeQuery();
            while(resultSet.next()) {
                doctorList.add(new Doctor(resultSet.getInt(1) ,// id
                        resultSet.getString(2) , //name
                        resultSet.getString(5) , //title
                        resultSet.getString(6) , // speciality
                        resultSet.getString(8) , // username
                        resultSet.getString(9)   // password
                ));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCTools.release(connection , statement , resultSet);
        }
        return doctorList;
    }

    @Override
    public Doctor login(String username, String password) {
        Connection connection = null;
        PreparedStatement statement = null;
        PreparedStatement statement1 = null;
        ResultSet resultSet = null;
        ResultSet resultSet1 = null;
        String sql = "select * from Doctor where username = ? and password = ?";
        String sql1 = "select * from Department where Department_id = ?";
        connection = JDBCTools.getConnection();
        Doctor doctor = null;
        try {
            statement = connection.prepareStatement(sql);
            statement1 = connection.prepareStatement(sql1);
            statement.setString(1 , username);
            statement.setString(2 , password);
            resultSet = statement.executeQuery();
            while(resultSet.next()) {
                statement1.setInt(1 , resultSet.getInt(7));
                resultSet1 = statement1.executeQuery();
                Integer dep_id = null;
                String dep_name = null;
                String  dep_phone = null;
                if(resultSet1.next()) {
                    dep_id = resultSet1.getInt(1);
                    dep_name = resultSet1.getString(2);
                    dep_phone = resultSet1.getString(3);
                }
                doctor = new Doctor(resultSet.getInt(1) , // id
                        resultSet.getString(2) , // name
                        resultSet.getInt(3), // age
                        resultSet.getString(4), // sex
                        resultSet.getString(5), // title
                        resultSet.getString(6), //speciality
                        new Department(dep_id ,dep_name ,dep_phone), // department
                        resultSet.getString(8),// username
                        resultSet.getString(9)); // password
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCTools.release(connection , statement , resultSet);
            JDBCTools.release(null , statement1 , resultSet1);
        }
        return doctor;
    }

    @Override
    public List<Doctor> findAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "select * from Doctor";
        connection = JDBCTools.getConnection();
        List<Doctor> doctorList = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while(resultSet.next()) {
                Department department = departmentRepository.findByDepartmentId(resultSet.getInt(7));
                doctorList.add(new Doctor(resultSet.getInt(1) ,// id
                        resultSet.getString(2) , //name
                        resultSet.getInt(3),//age
                        resultSet.getString(4),//sex
                        resultSet.getString(5) , //title
                        resultSet.getString(6) , // speciality
                        department , // department
                        resultSet.getString(8) , // username
                        resultSet.getString(9)   // password
                ));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCTools.release(connection , statement , resultSet);
        }
        return doctorList;
    }

    @Override
    public boolean findByUsername(String username) {
        boolean state = false;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "select * from doctor where username = ?";
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
    public void add(String name, Integer age, String sex, String title, String speciality, Integer departmentId, String username, String password) {
        Connection connection = null;
        PreparedStatement statement = null;
        String sql = "insert into Doctor(Doctor_name,Doctor_age , Doctor_sex , Doctor_title , Doctor_speciality , Department_id , username , password) VALUES(?,?,?,?,?,?,?,?)";
        connection = JDBCTools.getConnection();
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1 , name);
            statement.setInt(2 , age);
            statement.setString(3 , sex);
            statement.setString(4 , title);
            statement.setString(5 , speciality);
            statement.setInt(6 , departmentId);
            statement.setString(7 , username);
            statement.setString(8 , password);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCTools.release(connection , statement , null);
        }

    }

    @Override
    public void alter(Integer doctorId ,Integer age, String title, String speciality, String username ,Integer departmentId) {

        Connection connection = null;
        PreparedStatement statement = null;
        String sql = "update Doctor set Doctor_age = ? ,Doctor_title = ? , Doctor_speciality = ? , Department_id = ?  ,username = ? where Doctor_Id = ?";
        connection = JDBCTools.getConnection();
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1 , age);
            statement.setString(2 ,title);
            statement.setString(3 ,speciality);
            statement.setInt(4 , departmentId);
            statement.setString(5 , username);
            statement.setInt(6 , doctorId);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCTools.release(connection , statement , null);
        }
    }

    @Override
    public void deleteById(Integer id) {
        Connection connection = null;
        PreparedStatement statement = null;
        String sql = "delete from Doctor  where Doctor_Id = ?";
        connection = JDBCTools.getConnection();
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1 , id);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCTools.release(connection , statement , null);
        }
    }
}
