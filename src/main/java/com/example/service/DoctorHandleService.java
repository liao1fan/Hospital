package com.example.service;

import com.example.entity.Register;

import java.util.List;

public interface DoctorHandleService {
    public List<Register> findByDoctor(Integer doctorId);
}
