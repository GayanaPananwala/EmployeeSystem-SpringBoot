package com.example.employeespring.service;

import com.example.employeespring.exception.CustomException;
import com.example.employeespring.model.Employee;
import com.example.employeespring.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

//this will contain the business logic of the application. Methods will be called from the controller to handle http reqs
@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;


    public Employee createEmployee(Employee employee) {
        try {
            if (employee.getFirstName() == null || employee.getFirstName().isEmpty()) {
                throw new CustomException("First name is required");
            }
            if (employee.getLastName() == null || employee.getLastName().isEmpty()) {
                throw new CustomException("Last name is required");
            }
            if (employee.getDateOfBirth() == null) {
                throw new CustomException("Date of birth is required");
            }
            if (employee.getSalary() == null) {
                throw new CustomException("Salary is required");
            }
            if (employee.getDesignation() == null || employee.getDesignation().isEmpty()) {
                throw new CustomException("Designation is required");
            }

            // Validate date of birth
            try {
                LocalDate.parse(employee.getDateOfBirth());
            } catch (DateTimeParseException e) {
                throw new CustomException("Invalid date of birth");
            }

            String id = (UUID.randomUUID()).toString();
            employee.setId(id);
            return employeeRepo.save(employee);
        } catch(Exception e) {
            throw new CustomException("Failed to create the employee", e);
        }
    }

    public List<Employee> getAllEmployees() {
        try {
            return employeeRepo.findAll();
        } catch (Exception e) {
            throw new CustomException("Failed to retrieve all the employees", e);
        }
    }

    public Employee getEmployeeById(String id) {
        try {
            return employeeRepo.findById(id).orElseThrow(() -> new CustomException(("Employee not found with id "+ id)));
        } catch (Exception e) {
            throw new CustomException("Failed to retrieve employee with id " + id, e);
        }
    }

    public Employee updateEmployee(String id, Employee employee) {
        try {
            Employee existingEmployee = employeeRepo.findById(id)
                    .orElseThrow(() -> new CustomException("Employee not found with id " + id));

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
        } catch (Exception e) {
            throw new CustomException("Failed to update employee with id " + id, e);
        }
    }
    public void deleteEmployeeById(String id) {
        try {
            if(!employeeRepo.existsById(id)) {
                throw new CustomException("Employee not found with id " + id);
            }
            employeeRepo.deleteById(id);
        } catch (Exception e) {
            throw  new CustomException("Failed to delete employee with id " + id, e);
        }
    }
}
