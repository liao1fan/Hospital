package com.example.service;

import com.example.entity.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface DoctorHandleService {
    public List<Register> findByDoctor(Integer doctorId);
    public void changeState(Integer registerId, Integer state);
    public Register findById(Integer registerId);
    public void addTreat(Patient patient , Doctor doctor , String symptom , String diagnose );
    public List<Treat> findByDoctorId(Integer doctorId );
    public Treat findTreatById(Integer treatId);
    public void updateDiagnose(Integer treatId , String symptom , String diagnose);
    public List<Drug> findAllDrugs();
    public Drug findDrugByName(String drugName);
    public void addOneDrug(Integer treatId ,String drugName ,Integer drugNum );
    public List<GetDrug> findGetDrugByTreatId(Integer treatId);
}
