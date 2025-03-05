package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.entity.Employee;
import com.bridgelabz.employeepayrollapp.repository.EmployeePayrollRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//Use Annotations
@RestController
@RequestMapping("/employeepayrollservice")
@Slf4j
//create a class EmployeePayrollController to handle the request and response
public class EmployeePayrollController {

    //Use @Autowired Annotation
    @Autowired
    //create an object of EmployeePayrollRepository class
    private EmployeePayrollRepository useRepository;

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
        //Create an object of Employee
        Employee employee = useRepository.findById(id).orElse(null);

        //Create an object of employee class
        EmployeeDTO employeeDTO = new EmployeeDTO();

        //Check the condition and return the value
        if (employee != null) {
            //call the setter method to set the value
            employeeDTO.setId(employee.getId());
            employeeDTO.setName(employee.getEmployeeName());
            employeeDTO.setSalary(employee.getSalary());

            //Return the value
            return ResponseEntity.of(Optional.of(employeeDTO));
        }

        //Return the value with its http status
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //Use @GetMapping
    @GetMapping("/all")
    //Create a method to get all records
    public List<EmployeeDTO> getAllRecord(){
        //Call the method and return the value
        List<Employee> employees = useRepository.findAll();

        //Create a list to store the employee records
        List<EmployeeDTO> employeeDTOS = new ArrayList<>();

        //Use for loop
        for (Employee employee : employees) {
            employeeDTOS.add(new EmployeeDTO(employee.getId(), employee.getEmployeeName(), employee.getSalary()));
        }
        //Return the value
        return employeeDTOS;
    }

    //Use @PostMapping Annotation
    @PostMapping("/create")
    //Create a method createEmployeeRecord to create an employee record in database
    public ResponseEntity<Employee> createEmployeeRecord(@RequestBody Employee employee) {
        //call the save method
        useRepository.save(employee);
        //return the value with http status
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    //Use the @PutMapping Annotation
    @PutMapping("/update/{id}")
    //Create  a method to update the employee records
    public ResponseEntity<String> updateEmployeeRecords(@PathVariable Long id, @RequestBody Employee employee){
        //Create an object of Option class and call the method
        Optional<Employee> findDetails = useRepository.findById(id);

        //check the condition
        if (findDetails.isPresent()) {
            //Create an object to store details
            Employee updateDetails = findDetails.get();

            //call set method to set the value
            updateDetails.setEmployeeName(employee.getEmployeeName());
            updateDetails.setSalary(employee.getSalary());

            //save the details
            useRepository.save(updateDetails);
            //Return the value with Http status
            return new ResponseEntity<>("Details Updated Successfully", HttpStatus.OK);
        }
        //return the value if the record is not present  with its http status
        return new ResponseEntity<>("Records Not Found", HttpStatus.NOT_FOUND);
    }


    //Use the @DeleteMapping Annotation
    @DeleteMapping("/delete/{id}")
    //Create a method to delete the employee record by id
    public String deleteEmployeeRecord(@PathVariable Long id){

        //check the condition if the records exit or not
        if (useRepository.existsById(id)) {
            //Call the method to delete the records
            useRepository.deleteById(id);
            //Return the value
            return "Record Deleted";
        }
        //Return the value if record doesn't exist
        return "Record not found";
    }
}
