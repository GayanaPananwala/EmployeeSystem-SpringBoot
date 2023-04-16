package com.example.employeespring.service;

import com.example.employeespring.exception.EntityNotFoundException;
import com.example.employeespring.model.Employee;
import com.example.employeespring.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

//this will contain the business logic of the application. Methods will be called from the controller to handle http reqs
@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;


    public Employee createEmployee(Employee employee) {
        String id = (UUID.randomUUID()).toString();
        employee.setId(id);
        return employeeRepo.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    public Optional<Employee> getEmployeeById(String id) {
        return employeeRepo.findById(id);
    }

    public Employee updateEmployee(String id, Employee employee) {
        Employee existingEmployee = employeeRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Employee not found with id " + id) );

        if (employee.getFirstName() != null) {
            existingEmployee.setFirstName(employee.getFirstName());
        }
        if (employee.getLastName() != null) {
            existingEmployee.setLastName(employee.getLastName());
        }
        if (employee.getDateOfBirth() != null) {
            existingEmployee.setDateOfBirth(employee.getDateOfBirth());
        }
        if (employee.getSalary() != null) {
            existingEmployee.setSalary(employee.getSalary());
        }
        if (employee.getDesignation() != null) {
            existingEmployee.setDesignation(employee.getDesignation());
        }

        return employeeRepo.save(existingEmployee);
    }

    public void deleteEmployeeById(String id) {
        employeeRepo.deleteById(id);
    }
}
