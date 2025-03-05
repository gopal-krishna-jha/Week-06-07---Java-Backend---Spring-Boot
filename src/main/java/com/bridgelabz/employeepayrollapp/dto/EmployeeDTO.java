package com.bridgelabz.employeepayrollapp.dto;

import lombok.*;

//Use @Data Annotation
@Data
@AllArgsConstructor
@NoArgsConstructor
//Create a DTO class EmployeeDTO to transfer object
public class EmployeeDTO {

    //Create private variable to store value
    private  Long id;
    private String name;
    private double salary;
}
