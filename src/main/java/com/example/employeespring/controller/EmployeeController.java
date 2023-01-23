package com.example.employeespring.controller;

import com.example.employeespring.model.Employee;
import com.example.employeespring.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //marks the class as a request handler
public class EmployeeController {
    @Autowired
    private EmployeeRepo repo;

    @PostMapping("/addEmployee")
    public String addEmployee(@RequestBody Employee employee){
        repo.save(employee);
        return "Added the employee successfully!";
    }

    @GetMapping("/findAllEmployees")
    public List<Employee> getEmployees(){
        return repo.findAll();
    }
}
