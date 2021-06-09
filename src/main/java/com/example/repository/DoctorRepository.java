package com.example.repository;

import com.example.entity.Doctor;

import java.util.List;

public interface DoctorRepository {
    public Doctor login(String username , String password);
    public List<Doctor> findByDepartmentId(Integer departmentId);
    public Doctor findByDoctorId(Integer doctorId);
    public boolean findByUsername(String username);
}
