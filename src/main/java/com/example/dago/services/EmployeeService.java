package com.example.dago.services;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dago.repositories.EmployeeRepository;
import com.example.dago.models.Employee;

@Service
public class EmployeeService {
    
    @Autowired
    EmployeeRepository employeeRepository ;

    public List<Employee> findAll(){
        return (List<Employee>)employeeRepository.findAll();
    }

    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee update(Employee employee, int employeeId){
        Employee empDb = employeeRepository.findById(employeeId).get();
        if(Objects.nonNull(employee) && !"".equalsIgnoreCase(employee.getName())){
            empDb.setName(employee.getName());
        }
        return empDb;
    }

    public void delete(int employeeId){
        employeeRepository.deleteById(employeeId);
    }
}
