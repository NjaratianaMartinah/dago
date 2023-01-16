package com.example.dago.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.dago.models.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Integer>{
}