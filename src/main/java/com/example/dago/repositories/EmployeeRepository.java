package com.example.dago.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.dago.models.Employee;

public interface EmployeeRepository extends CrudRepository<Employee,Integer>{
}