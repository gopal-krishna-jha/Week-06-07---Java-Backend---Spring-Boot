package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.entity.Employee;
import com.bridgelabz.employeepayrollapp.repository.EmployeePayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//Use @Service Annotation
@Service

//USe @Component Annotation
@Component
//Create a class EmployeePayrollServices to provide the services
public class EmployeePayrollServices {

    //Create an object EmployeePayrollRepository
    private final EmployeePayrollRepository useRepository;

    @Autowired
    //Parameterized constructor to initialize variable
    public EmployeePayrollServices(EmployeePayrollRepository useRepository) {
        this.useRepository = useRepository;
    }

    //Create a method to find the details of employee by id
    public ResponseEntity<EmployeeDTO> findDetailsById(Long id) {
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

    //Create a method to create the employee record
    public ResponseEntity<Employee> createRecord(Employee employee) {
        //call the save method
        useRepository.save(employee);
        //return the value with http status
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    //Create a method to get all the records of employee
    public List<EmployeeDTO> findAllRecords() {
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

    //Create a method to delete record by id
    public boolean deleteRecords(Long id) {
        //check the condition if the records exit or not
        if (useRepository.existsById(id)) {
            //Call the method to delete the records
            useRepository.deleteById(id);
            //Return true
            return true;
        }
        //Return false if record doesn't exist
        return false;
    }

    //Create a method to update the record
    public ResponseEntity<String> updateRecord(Long id, Employee employee) {
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
}
