package com.example.service.Impl;

import com.example.entity.Department;
import com.example.entity.Doctor;
import com.example.entity.Doctor_state;
import com.example.entity.Treat;
import com.example.repository.*;
import com.example.repository.Impl.*;
import com.example.service.RegisterService;

import java.util.Date;
import java.util.List;

public class RegisterServiceImpl implements RegisterService {


    private static DepartmentRepository departmentRepository = new DepartmentRepositoryImpl();

    private static DoctorRepository doctorRepository = new DoctorRepositoryImpl();

    private static DoctorStateRepository doctorStateRepository = new DoctorStateRepositoryImpl();

    private static RegisterRepository registerRepository = new RegisterRepositoryImpl();

    private static TreatRepository treatRepository = new TreatRepositoryImpl();

    @Override
    public List<Doctor> findAllDoctor(Integer departmentId) {
        return doctorRepository.findByDepartmentId(departmentId);
    }

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Doctor findByDoctor(Integer doctorId) {
        return doctorRepository.findByDoctorId(doctorId);
    }

    @Override
    public List<Doctor_state> findAllDateByDepartmentId(Integer departmentId) {
        return doctorStateRepository.findAllDateByDepartmentId(departmentId);
    }

    @Override
    public Doctor_state findByDoctorStateId(Integer doctorStateId) {
        return doctorStateRepository.findByDoctorStateId(doctorStateId);
    }

    @Override
    public Department findByDepartmentId(Integer departmentId) {
        return departmentRepository.findByDepartmentId(departmentId);
    }

    @Override
    public void addRegister(Integer patientId, Integer doctorId, Date time, Double fee, Integer state) {
        registerRepository.addRegister(patientId , doctorId , time , fee , state );
    }

    @Override
    public void changeNum(Integer doctorStateId) {
        doctorStateRepository.changeNum(doctorStateId);
    }

    @Override
    public List<Treat> findAllTreatByPatientId(Integer patientId) {
        return treatRepository.findByPatientId(patientId);
    }

    @Override
    public Treat findTreatByTreatId(Integer treatId) {
        return treatRepository.findById(treatId);
    }
}
