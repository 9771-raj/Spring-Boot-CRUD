package com.startproject.spring.controller;

import com.startproject.spring.entity.Department;
import com.startproject.spring.service.departmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.validation.Valid;

@RestController
public class departmentController {
      @Autowired
      private departmentService service;

      //Post mapping of department

      @PostMapping("/departments")       // validation added on department Name
      public Department saveDeprtment(@Valid @RequestBody Department department){
            //departmentService service=new departmentServiceImpl();
            return service.saveDepartment(department);
      }

      // Get Mapping of department return list of department
      @GetMapping("/departments")
      public List<Department> fetch_departments(){
            return service.fetch_departments();
      }

      // Get Department by its Id
      @GetMapping("/departments/{id}")
      public Department fetchDepartment_byId(@PathVariable("id") Long departmentId) {
            return service.fetchDepartment_byId(departmentId);
      }
      
      @DeleteMapping("/departments/{id}")
      public String deleteDepartment_byId(@PathVariable("id") Long departmentId){
            service.deleteDepartment_byId(departmentId);
            return "Delete Department Successfully!!!";
      }

      @PutMapping("/departments/{id}")
      public Department updateDepartment_byId(@PathVariable("id") Long departmentId
                                             ,@RequestBody Department department){
            return service.updateDepartment_byId(departmentId,department);
      }

      // fetch department by its Name
      @GetMapping("/departments/name/{name}")
      public Department fetchDepartment_byName(@PathVariable("name") String name){
            return service.fetchDepartment_byName(name);
      }

}
