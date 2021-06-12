package com.example.repository.Impl;

import com.example.entity.Drug;
import com.example.repository.DrugRepository;
import com.example.utils.JDBCTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DrugRepositoryImpl implements DrugRepository {
    @Override
    public List<Drug> findAllDrugs() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "select * from Drug";
        List<Drug> drugList = new ArrayList<>();
        connection = JDBCTools.getConnection();
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while(resultSet.next()) {
                drugList.add(new Drug(resultSet.getInt(1) , resultSet.getString(2),
                        resultSet.getInt(3) , resultSet.getString(4) ,
                        resultSet.getDouble(5)));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCTools.release(connection , statement , resultSet);
        }
        return drugList;
    }

    @Override
    public Drug findByName(String name) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "select * from Drug where Drug_name = ?";
        Drug drug = null;
        connection = JDBCTools.getConnection();
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            resultSet = statement.executeQuery();
            while(resultSet.next()) {
                drug = new Drug(resultSet.getInt(1) , resultSet.getString(2),
                        resultSet.getInt(3) , resultSet.getString(4) ,
                        resultSet.getDouble(5));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCTools.release(connection , statement , resultSet);
        }
        return drug;
    }

    @Override
    public Drug findById(Integer id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "select * from Drug where Drug_id = ?";
        Drug drug = null;
        connection = JDBCTools.getConnection();
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            while(resultSet.next()) {
                drug = new Drug(resultSet.getInt(1) , resultSet.getString(2),
                        resultSet.getInt(3) , resultSet.getString(4) ,
                        resultSet.getDouble(5));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCTools.release(connection , statement , resultSet);
        }
        return drug;
    }

}
