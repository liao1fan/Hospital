package com.example.repository;

import com.example.entity.Drug;

import java.util.List;

public interface DrugRepository {
    public List<Drug> findAllDrugs();

    public Drug findByName(String name);

    public Drug findById(Integer id);
}
