package com.example.service.Impl;

import com.example.entity.*;
import com.example.repository.DrugRepository;
import com.example.repository.GetDrugRepository;
import com.example.repository.Impl.DrugRepositoryImpl;
import com.example.repository.Impl.GetDrugRepositoryImpl;
import com.example.repository.Impl.RegisterRepositoryImpl;
import com.example.repository.Impl.TreatRepositoryImpl;
import com.example.repository.RegisterRepository;
import com.example.repository.TreatRepository;
import com.example.service.DoctorHandleService;

import java.text.SimpleDateFormat;
import java.util.*;

public class DoctorHandleServiceImpl implements DoctorHandleService {

    private static RegisterRepository registerRepository = new RegisterRepositoryImpl();

    private static TreatRepository treatRepository = new TreatRepositoryImpl();

    private static DrugRepository drugRepository = new DrugRepositoryImpl();

    private static GetDrugRepository getDrugRepository = new GetDrugRepositoryImpl();

    @Override
    public List<Register> findByDoctor(Integer doctorId) {
        return registerRepository.findByDoctorId(doctorId);
    }

    @Override
    public void changeState(Integer registerId, Integer state) {
        registerRepository.changeState(registerId , state);
    }

    @Override
    public Register findById(Integer registerId) {
        return registerRepository.findById(registerId);
    }

    @Override
    public void addTreat(Patient patient, Doctor doctor,  String symptom, String diagnose) {

        // 获取确认时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        Date date = new Date();// new Date()为获取当前系统时间

        treatRepository.addTreat(patient , doctor , new java.sql.Timestamp(date.getTime()) , symptom , diagnose);
    }

    @Override
    public List<Treat> findByDoctorId(Integer doctorId) {
        return treatRepository.findByDoctorId(doctorId);
    }

    @Override
    public Treat findTreatById(Integer treatId) {
        return treatRepository.findById(treatId);
    }

    @Override
    public void updateDiagnose(Integer treatId, String symptom, String diagnose) {
        treatRepository.updateDiagnose(treatId , symptom , diagnose);
    }

    @Override
    public List<Drug> findAllDrugs() {
        return drugRepository.findAllDrugs();
    }


    @Override
    public Drug findDrugByName(String drugName) {
        return drugRepository.findByName(drugName);
    }

    @Override
    public void addOneDrug(Integer treatId, String drugName, Integer drugNum) {
        Map<Drug , Integer> map = new HashMap<>();
        Drug drug = drugRepository.findByName(drugName);
        Treat treat = treatRepository.findById(treatId);
        map.put(drug , drugNum);
        getDrugRepository.add(drug.getId() , drugNum , treat.getTime() , treat.getId());
    }

    @Override
    public List<GetDrug> findGetDrugByTreatId(Integer treatId) {
        return getDrugRepository.findByTreatId(treatId);
    }
}
