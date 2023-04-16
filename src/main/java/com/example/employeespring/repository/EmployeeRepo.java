package com.example.employeespring.repository;

import com.example.employeespring.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepo extends MongoRepository<Employee, String> {
}
