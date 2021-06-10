package com.example.repository;

import com.example.entity.Doctor;
import com.example.entity.Drug;
import com.example.entity.Patient;
import com.example.entity.Register;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface RegisterRepository {
    public void addRegister(Integer patientId, Integer doctorId  , Date time , Double fee , Integer state);

    public List<Register> findByDoctorId(Integer doctorId);

    public void changeState(Integer registerId , Integer state);

    public Register findById(Integer registerId);


}
