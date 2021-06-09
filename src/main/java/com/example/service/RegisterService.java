package com.example.service;

import com.example.entity.Department;
import com.example.entity.Doctor;
import com.example.entity.Doctor_state;

import java.util.Date;
import java.util.List;

// 挂号服务
public interface RegisterService {
    public List<Department> findAll();
    public List<Doctor> findAllDoctor(Integer departmentId);
    public Doctor findByDoctor(Integer doctorId);
    public List<Doctor_state> findAllDateByDepartmentId(Integer departmentId);
    public Doctor_state findByDoctorStateId(Integer doctorStateId);
    public Department findByDepartmentId(Integer departmentId);
    public void addRegister(Integer patientId, Integer doctorId , Date time , Double fee , Integer state);
    public void changeNum(Integer doctorStateId);
}
