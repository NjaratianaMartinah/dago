package com.example.dago.controllers.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.dago.models.Employee;

public interface EmployeeRepository extends CrudRepository<Employee,Integer>{

    List<Employee> findAll();

    Employee findById(int id);

}