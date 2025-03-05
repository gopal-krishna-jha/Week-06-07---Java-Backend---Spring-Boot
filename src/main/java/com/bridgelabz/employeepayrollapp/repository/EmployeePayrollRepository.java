package com.bridgelabz.employeepayrollapp.repository;

import com.bridgelabz.employeepayrollapp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Use @Repository Annotation
@Repository
//create an interface EmployeePayrollRepository which extends JpaRepository to perform some CRUD operation
public interface EmployeePayrollRepository extends JpaRepository<Employee,Long> {
}
