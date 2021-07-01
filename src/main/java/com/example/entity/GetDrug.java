package com.example.entity;

import com.example.repository.DrugRepository;
import com.example.repository.Impl.DrugRepositoryImpl;

import java.util.Iterator;
import java.util.Map;

public class GetDrug {
    private Integer id;
    private Treat treat;
    private Map<Drug , Integer> drugList;

    public GetDrug(Integer id, Treat treat, Map<Drug, Integer> drugList) {
        this.id = id;
        this.treat = treat;
        this.drugList = drugList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Treat getTreat() {
        return treat;
    }

    public void setTreat(Treat treat) {
        this.treat = treat;
    }

    public Map<Drug, Integer> getDrugList() {
        return drugList;
    }

    public void setDrugList(Map<Drug, Integer> drugList) {
        this.drugList = drugList;
    }

    public String getDrugInfo() {
        String drug_info = "";

        Iterator<Map.Entry<Drug, Integer>> iterator = this.drugList.entrySet().iterator();
        Map.Entry<Drug ,Integer> entry = null;
        while(iterator.hasNext()){
            entry = iterator.next();
            drug_info += entry.getKey().getName() + " * " + Integer.toString(entry.getValue()) ;
            if(iterator.hasNext()) {
                drug_info += ";\n";
            }
        }
        return drug_info;
    }
    public Double getDrugTotalCost(){
        DrugRepository drugRepository = new DrugRepositoryImpl();
        Drug drug = null;
        Double sum = 0.0;
        Integer num = 0;
        Double price = 0.0;
        Iterator<Map.Entry<Drug, Integer>> iterator = this.drugList.entrySet().iterator();
        Map.Entry<Drug ,Integer> entry = null;
        while(iterator.hasNext()){
            entry = iterator.next();
            num = entry.getValue();
            String name = entry.getKey().getName();
            drug = drugRepository.findByName(name);
            sum += drug.getPrice() * num;
        }
        return sum;
    }
}
