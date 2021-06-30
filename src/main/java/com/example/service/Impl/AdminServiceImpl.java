package com.example.service.Impl;

import com.example.entity.Department;
import com.example.entity.Doctor;
import com.example.entity.Patient;
import com.example.repository.DepartmentRepository;
import com.example.repository.DoctorRepository;
import com.example.repository.Impl.DepartmentRepositoryImpl;
import com.example.repository.Impl.DoctorRepositoryImpl;
import com.example.repository.Impl.PatientRepositoryImpl;
import com.example.repository.PatientRepository;
import com.example.service.AdminService;

import java.util.List;

public class AdminServiceImpl implements AdminService {
    private PatientRepository patientRepository = new PatientRepositoryImpl();
    private DoctorRepository doctorRepository = new DoctorRepositoryImpl();
    private DepartmentRepository departmentRepository = new DepartmentRepositoryImpl();
    @Override
    public List<Patient> findAllPatient() {
        return patientRepository.findAll();
    }

    @Override
    public List<Doctor> findAllDoctor() {
        return doctorRepository.findAll();
    }

    @Override
    public List<Department> findAllDepartment() {
        return departmentRepository.findAll();
    }
}
