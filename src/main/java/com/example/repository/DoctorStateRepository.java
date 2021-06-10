package com.example.repository;

import com.example.entity.Doctor_state;

import java.util.List;

public interface DoctorStateRepository {
    public List<Doctor_state> findAllDateByDepartmentId(Integer departmentid);
    public Doctor_state findByDoctorStateId(Integer doctorStateId);
    public void changeNum(Integer doctorStateId);
}
