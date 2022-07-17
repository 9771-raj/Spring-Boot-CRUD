package com.startproject.spring.service;

import com.startproject.spring.entity.Department;

import java.util.List;

public interface departmentService {


    public List<Department> fetch_departments();

    public Department saveDepartment(Department department);

    public Department fetchDepartment_byId(Long departmentId);

    public void deleteDepartment_byId(Long departmentId);

    public Department updateDepartment_byId(Long departmentId, Department department);

    public Department fetchDepartment_byName(String name);
}
