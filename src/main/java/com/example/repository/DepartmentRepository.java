package com.example.repository;

import com.example.entity.Department;

import java.util.List;

public interface DepartmentRepository {
    public List<Department> findAll();
    public Department findByDepartmentId(Integer departmentId);
    public void alterPhone(Integer id , String phone);
    public void add(String name , String phone);
    public Department findByDepartmentName(String name);
}
