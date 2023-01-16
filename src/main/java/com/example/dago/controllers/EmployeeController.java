package com.example.dago.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dago.models.Employee;
import com.example.dago.services.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
	public List<Employee> findAllEmployee() {
        return employeeService.findAll();
	}

     // Save operation
    @PostMapping("/")
    public Employee saveEmployee(@RequestBody Employee employee){
        employee.setStartDate(new Date());
        return employeeService.save(employee);
    }

}
