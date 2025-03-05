package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.entity.Employee;
import com.bridgelabz.employeepayrollapp.repository.EmployeePayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Use @Service Annotation
@Service
//Create a class EmployeePayrollServices to provide the services
public class EmployeePayrollServices {

    //Use Autowired Annotation
    @Autowired
    private EmployeePayrollRepository useRepository;

    //Create a method to find the details of employee by id
    public Optional<Employee> findDetailsById(Long id) {
        //call the findById method and return the value
        return useRepository.findById(id);
    }

    //Create a method to create the employee record
    public Employee createRecord(Employee employee) {
        //call the save method and return the value
        return useRepository.save(employee);
    }

    //Create a method to get all the records of employee
    public List<Employee> findAllRecords(){
        //Call the method and return the value
        return  useRepository.findAll();
    }

    //Create a method to delete record by id
    public boolean deleteRecords(Long id){
        //check the condition if the records exit or not
        if(useRepository.existsById(id)){
            //Call the method to delete the records
            useRepository.deleteById(id);
            //Return true
            return true;
        }
        //Return false if record doesn't exist
        return false;
    }

    //Create a method to update the record
    public Optional<Employee> updateRecord(Long id, Employee employee){
        //Create an object of Option class and call the method
        Optional<Employee> updateDetails = useRepository.findById(id);

        //check the condition
        if(updateDetails.isPresent()){
            //call a method to set the value
            employee.setId(id);
            //Create  an object of Employee class
            Employee emp = updateDetails.get();
            emp = employee;
            //save the details
            useRepository.save(emp);
            //Return the value
            return Optional.of(emp);
        }
        //return the value if the record is not present
        return Optional.empty();
    }
}
