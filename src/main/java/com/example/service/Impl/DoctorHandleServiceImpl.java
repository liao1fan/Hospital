package com.example.service.Impl;

import com.example.entity.*;
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
    public void addTreat(Patient patient, Doctor doctor,  String symptom, String diagnose, Map<Drug , Integer> drug_list) {
        String drug_info = "";

        Iterator<Map.Entry<Drug, Integer>> iterator = drug_list.entrySet().iterator();
        Map.Entry<Drug, Integer> entry = null;
        while(iterator.hasNext()){
            drug_info += iterator.next().getKey().getName() + " * " + Integer.toString(iterator.next().getValue()) ;
            if(iterator.hasNext()) {
                drug_info += ";\n";
            }
        }
        // 获取确认时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        Date date = new Date();// new Date()为获取当前系统时间

        treatRepository.addTreat(patient , doctor , new java.sql.Timestamp(date.getTime()) , symptom , diagnose , drug_info);
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
}
