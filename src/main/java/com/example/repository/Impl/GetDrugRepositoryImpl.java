package com.example.repository.Impl;

import com.example.entity.Drug;
import com.example.entity.GetDrug;
import com.example.entity.Treat;
import com.example.repository.DrugRepository;
import com.example.repository.GetDrugRepository;
import com.example.repository.TreatRepository;
import com.example.utils.JDBCTools;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetDrugRepositoryImpl implements GetDrugRepository {

    private static TreatRepository treatRepository = new TreatRepositoryImpl();

    private static DrugRepository drugRepository = new DrugRepositoryImpl();

    @Override
    public void add(Integer drugId, Integer drugNum, Timestamp time, Integer treatId) {
        Connection connection = null;
        PreparedStatement statement = null;
        connection = JDBCTools.getConnection();
        String sql = "insert into getdrug(drug_id, drug_num, get_time, treat_id) VALUES (? , ? , ? ,? ) ";

        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, drugId);
            statement.setInt(2, drugNum);
            statement.setTimestamp(3, time);
            statement.setInt(4, treatId);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCTools.release(connection, statement, null);
        }
    }

    @Override
    public List<GetDrug> findByTreatId(Integer treatId) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<GetDrug> getDrugList = new ArrayList<>();
        connection = JDBCTools.getConnection();
        String sql = "select * from getdrug where treat_id = ?";

        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, treatId);
            resultSet = statement.executeQuery();
            Map<Drug , Integer> map = null;
            while(resultSet.next()) {
                map = new HashMap<>();
                map.put(drugRepository.findById(resultSet.getInt(2)) , resultSet.getInt(3));
                getDrugList.add( new GetDrug(resultSet.getInt(1),
                        treatRepository.findById(treatId),  map));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCTools.release(connection, statement, resultSet);
        }
        return getDrugList;
    }
}
