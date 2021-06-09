package com.example.repository;

import com.example.entity.Register;

import java.util.Date;
import java.util.List;

public interface RegisterRepository {
    public void addRegister(Integer patientId, Integer doctorId  , Date time , Double fee , Integer state);

    public List<Register> findByDoctorId(Integer doctorId);

    public void changeNum(Integer doctorStateId);
}
