package com.example.repository;

import com.example.entity.GetDrug;

import java.util.List;

public interface GetDrugRepository {

    public void add(Integer drugId , Integer drugNum ,java.sql.Timestamp time , Integer treatId);

    public List<GetDrug> findByTreatId(Integer treatId);
}
