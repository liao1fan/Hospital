package com.example.service;

import com.example.entity.Department;
import com.example.entity.Doctor;
import com.example.entity.Patient;

import java.util.List;

public interface AdminService {
    List<Patient> findAllPatient();
    List<Doctor> findAllDoctor();
    List<Department> findAllDepartment();
}
