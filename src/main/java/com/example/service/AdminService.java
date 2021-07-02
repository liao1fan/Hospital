package com.example.service;

import com.example.entity.Department;
import com.example.entity.Doctor;
import com.example.entity.Patient;

import java.util.List;

public interface AdminService {
    List<Patient> findAllPatient();
    List<Doctor> findAllDoctor();
    List<Department> findAllDepartment();
    void alterDepartmentPhone(Integer id , String phone);
    void addDoctor(String name , Integer age , String sex, String title , String speciality , String departmentName , String username , String password);
    void addPatient(String name ,Integer age ,String sex ,String  address ,String  phone ,String  username ,String  password);
}
