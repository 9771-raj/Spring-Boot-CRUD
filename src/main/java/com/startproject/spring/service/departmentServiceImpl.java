package com.startproject.spring.service;

import com.startproject.spring.entity.Department;
import com.startproject.spring.repositery.departmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class departmentServiceImpl implements departmentService{

    @Autowired
    private departmentRepo departmentrepo;

    @Override
    public List<Department> fetch_departments() {
        return departmentrepo.findAll();
    }

    @Override
    public Department saveDepartment(Department department) {
        return departmentrepo.save(department);
    }
    @Override
    public Department fetchDepartment_byId(Long departmentId){
        return departmentrepo.findById(departmentId).get();
    }
    @Override
    public void deleteDepartment_byId(Long departmentId){
        departmentrepo.deleteById(departmentId);
    }
    @Override
    public Department updateDepartment_byId(Long departmentId, Department department){
        Department depar_db=departmentrepo.findById(departmentId).get();

        if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())){
            depar_db.setDepartmentName(department.getDepartmentName());
        }

        if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())){
            depar_db.setDepartmentAddress(department.getDepartmentAddress());
        }

        if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())){
            depar_db.setDepartmentCode(department.getDepartmentCode());
        }

        return departmentrepo.save(depar_db);
    }

    @Override
    public Department fetchDepartment_byName(String name){
           return departmentrepo.findByDepartmentNameIgnoreCase(name);
    }

}
