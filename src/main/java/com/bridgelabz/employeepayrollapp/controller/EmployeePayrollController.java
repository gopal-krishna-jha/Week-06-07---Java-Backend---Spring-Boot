package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.entity.Employee;
import com.bridgelabz.employeepayrollapp.service.EmployeePayrollServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//Use Annotations
@RestController
@RequestMapping("/employeepayrollservice")

//create a class EmployeePayrollController to handle the request and response
public class EmployeePayrollController {

    //Use @Autowired Annotation
    @Autowired
    //create an object of EmployeePayrollServices class
    private EmployeePayrollServices useServices;

    //Use @GetMapping Annotation
    @GetMapping(value = {"/", ""})
    //Create a method to get the message
    public String getMapping() {
        return "Welcome to Employee Payroll App";
    }

    //Use @GetMapping Annotation to get the details
    @GetMapping("/get/{id}")
    //Create a method to get the employee details by the id
    public Optional<Employee> getEmployeeDetails(@PathVariable Long id) {
        //Call the method and return the value
        return useServices.findDetailsById(id);
    }

    @GetMapping("/all")
    public List<Employee> getAllRecord(){
        return useServices.findAllRecords();
    }

    //Use @PostMapping Annotation
    @PostMapping("/create")
    //Create a method createEmployeeRecord to create an employee record in database
    public Employee createEmployeeRecord(@RequestBody Employee employee) {
        //Call the method and return the value
        return useServices.createRecord(employee);
    }

    //Use the @PutMapping Annotation
    @PutMapping("/update/{id}")
    //Create  a method to update the employee records
    public Optional<Employee> updateEmployeeRecords(@PathVariable Long id, @RequestBody Employee employee){
        //return the value
        return useServices.updateRecord(id,employee);
    }


    //Use the @DeleteMapping Annotation
    @DeleteMapping("/delete/{id}")
    //Create a method to delete the employee record by id
    public String deleteEmployeeRecord(@PathVariable Long id){
        //call the method and return the result
        return useServices.deleteRecords(id)?"Record Deleted":"Record Not Found";
    }
}
