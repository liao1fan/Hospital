package com.example.repository;

import com.example.entity.Patient;

import java.util.List;

public interface PatientRepository {
    public Patient login(String username , String password);

    public boolean findByUsername(String username);

    public Patient findById(Integer id);

    public List<Patient> findAll();

    public void deleteById(Integer patientId);

    public void add(String name ,Integer age ,String sex ,String address ,String phone ,String username ,String password);

    public void alter(Integer patientId ,Integer age ,String address,String phone ,String username );
}
