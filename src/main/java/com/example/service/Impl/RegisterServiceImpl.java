package com.example.service.Impl;

import com.example.entity.Department;
import com.example.entity.Doctor;
import com.example.entity.Doctor_state;
import com.example.repository.DepartmentRepository;
import com.example.repository.DoctorRepository;
import com.example.repository.DoctorStateRepository;
import com.example.repository.Impl.DepartmentRepositoryImpl;
import com.example.repository.Impl.DoctorRepositoryImpl;
import com.example.repository.Impl.DoctorStateRepositoryImpl;
import com.example.repository.Impl.RegisterRepositoryImpl;
import com.example.repository.RegisterRepository;
import com.example.service.RegisterService;

import java.util.Date;
import java.util.List;

public class RegisterServiceImpl implements RegisterService {


    private static DepartmentRepository departmentRepository = new DepartmentRepositoryImpl();

    private static DoctorRepository doctorRepository = new DoctorRepositoryImpl();

    private static DoctorStateRepository doctorStateRepository = new DoctorStateRepositoryImpl();

    private static RegisterRepository registerRepository = new RegisterRepositoryImpl();

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
        registerRepository.changeNum(doctorStateId);
    }
}
