package com.example.dago.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

     // Update operation
     @PutMapping("/{id}")
     public Employee
     updateEmployee(@RequestBody Employee employee, @PathVariable("id") int employeeId){
        return employeeService.update(employee, employeeId);
     }

     // Delete operation
     @DeleteMapping("/{id}")
     public String deleteEmployeeById(@PathVariable("id") int employeeId){
         employeeService.delete( employeeId);
         return "Deleted Successfully";
     }

}
