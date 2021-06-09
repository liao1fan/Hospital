package com.example.repository.Impl;

import com.example.entity.Department;
import com.example.entity.Patient;
import com.example.repository.DepartmentRepository;
import com.example.utils.JDBCTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentRepositoryImpl implements DepartmentRepository {
    @Override
    public List<Department> findAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "select * from Department";
        connection = JDBCTools.getConnection();
        List<Department> departmentList = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while(resultSet.next()) {
                 departmentList.add(new Department(resultSet.getInt(1) , resultSet.getString(2),resultSet.getString(3)));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCTools.release(connection , statement , resultSet);
        }
        return departmentList;
    }

    @Override
    public Department findByDepartmentId(Integer departmentId) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "select * from Department where Department_id = ?";
        connection = JDBCTools.getConnection();
        Department department = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1 , departmentId);
            resultSet = statement.executeQuery();
            while(resultSet.next()) {
                department = new Department(resultSet.getInt(1) , resultSet.getString(2),resultSet.getString(3));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCTools.release(connection , statement , resultSet);
        }
        return department;
    }
}
