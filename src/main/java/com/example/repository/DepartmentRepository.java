package com.example.repository;

import com.example.entity.Department;

import java.util.List;

public interface DepartmentRepository {
    public List<Department> findAll();
    public Department findByDepartmentId(Integer departmentId);
}
