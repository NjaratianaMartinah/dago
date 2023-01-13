package com.example.dago.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.example.dago.controllers.repositories.EmployeeRepository;
import com.example.dago.models.Employee;

@Configuration
public class EmployeeService {
    
    @Autowired
    EmployeeRepository employeeRepository ;

    public List<Employee> findAllEmployees(){
        List<Employee> employees = employeeRepository.findAll();
        return employees;
    }
}
