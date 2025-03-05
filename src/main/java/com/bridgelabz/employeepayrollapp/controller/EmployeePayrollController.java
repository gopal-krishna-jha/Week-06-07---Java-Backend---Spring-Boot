package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.entity.Employee;
import com.bridgelabz.employeepayrollapp.service.EmployeePayrollServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Use Annotations
@RestController
@RequestMapping("/employeepayrollservice")
@Slf4j
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
    public ResponseEntity<EmployeeDTO> getEmployeeDetails(@PathVariable Long id) {
        //Call the method and return the value
        return useServices.findDetailsById(id);
    }

    @GetMapping("/all")
    public List<EmployeeDTO> getAllRecord(){
        return useServices.findAllRecords();
    }

    //Use @PostMapping Annotation
    @PostMapping("/create")
    //Create a method createEmployeeRecord to create an employee record in database
    public ResponseEntity<Employee> createEmployeeRecord(@RequestBody Employee employee) {
        //Use logger to give the information
        log.info("Creating new  Employee Record");
        //Call the method and return the value
        return useServices.createRecord(employee);
    }

    //Use the @PutMapping Annotation
    @PutMapping("/update/{id}")
    //Create  a method to update the employee records
    public ResponseEntity<String> updateEmployeeRecords(@PathVariable Long id, @RequestBody Employee employee){
        //Use logger to give the warning
        log.warn("Employee Id can't be changed");
        //return the value
        return useServices.updateRecord(id,employee);
    }


    //Use the @DeleteMapping Annotation
    @DeleteMapping("/delete/{id}")
    //Create a method to delete the employee record by id
    public String deleteEmployeeRecord(@PathVariable Long id){

        //Use logger to give the info.
        log.info("Employee Record Deleting.");
        //call the method and return the result
        return useServices.deleteRecords(id)?"Record Deleted":"Record Not Found";
    }
}
