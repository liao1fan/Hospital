package com.example.repository;

import com.example.entity.Department;
import com.example.entity.Doctor;

import java.util.List;

public interface DoctorRepository {
    public Doctor login(String username , String password);
    public List<Doctor> findByDepartmentId(Integer departmentId);
    public Doctor findByDoctorId(Integer doctorId);
    public boolean findByUsername(String username);
    public List<Doctor> findAll();
    public void add(String name , Integer age , String sex , String title , String speciality , Integer departmentId , String username , String password);
    public void alter(Integer  doctorId,Integer age , String title, String speciality , String username ,Integer departmentId);
    public void deleteById(Integer id);
}
