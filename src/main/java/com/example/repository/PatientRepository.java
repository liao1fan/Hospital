package com.example.repository;

import com.example.entity.Patient;

public interface PatientRepository {
    public Patient login(String username , String password);

    public boolean findByUsername(String username);

    public Patient findById(Integer id);
}
