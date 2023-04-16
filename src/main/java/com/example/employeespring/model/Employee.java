package com.example.employeespring.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "Employee")
public class Employee {

    //The variables are private since they contain sensitive information
    @Id //Indicates the object's ID
    private String id;

    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private Double salary;
    private String designation;

    //public get and set methods to access and update the value of private id variable
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    //public get and set methods to access and update the value of private firstName variable
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //public get and set methods to access and update the value of private lastName variable
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //public get and set methods to access and update the value of private dateOfBirth variable
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    //public get and set methods to access and update the value of private salary variable
    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
    //public get and set methods to access and update the value of private designation variable
    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
