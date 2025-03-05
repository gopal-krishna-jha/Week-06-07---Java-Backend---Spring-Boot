package com.bridgelabz.employeepayrollapp.entity;

import jakarta.persistence.*;

//Use @Table Annotation
@Table(name = "EMPLOYEE")
//Use the @Entity Annotation
@Entity

//Create a class Employee to indicate the employee details
public class Employee {

    //Use @Id and @GeneratedValue Annotation
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Create a private variable to store employee details
    private Long id;
    private String employeeName;
    private String department;
    private double salary;

    //Create a getter method to get id
    public Long getId() {
        //Return the value
        return id;
    }

    //Create a setter method  to set id
    public void setId(Long id) {
        //use this keyword to set the value
        this.id = id;
    }

    //Create a getter method  to get employeeName
    public String getEmployeeName() {
        //Return the value
        return employeeName;
    }

    //Create a setter method  to set employeeName
    public void setEmployeeName(String employeeName) {
        //use this keyword to set the value
        this.employeeName = employeeName;
    }

    //Create a getter method to get department
    public String getDepartment() {
        //Return the value
        return department;
    }

    //Create a setter method  to set department
    public void setDepartment(String department) {
        //use this keyword to set the value
        this.department = department;
    }

    //Create a getter method to get salary
    public double getSalary() {
        //Return the value
        return salary;
    }

    //Create a setter method  to set salary
    public void setSalary(double salary) {
        //use this keyword to set the value
        this.salary = salary;
    }
}