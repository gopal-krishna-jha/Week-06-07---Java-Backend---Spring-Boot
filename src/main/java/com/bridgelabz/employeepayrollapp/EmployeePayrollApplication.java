package com.bridgelabz.employeepayrollapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Use @SpringBootApplication Annotation
@SpringBootApplication
//Create a class EmployeePayrollApplication to start the application
public class EmployeePayrollApplication {

    public static void main(String[] args) {
        //Call the run method to run the server
        SpringApplication.run(EmployeePayrollApplication.class, args);
    }
}
