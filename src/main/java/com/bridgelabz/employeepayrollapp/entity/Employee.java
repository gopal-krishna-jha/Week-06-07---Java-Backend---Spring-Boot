package com.bridgelabz.employeepayrollapp.entity;

import jakarta.persistence.*;
import lombok.*;

//Use @Table Annotation
@Table(name = "EMPLOYEE")
//Use the @Entity Annotation
@Entity
//Use lombok Annotations
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

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
    private String password;
}