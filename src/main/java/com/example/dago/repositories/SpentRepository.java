package com.example.dago.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.dago.models.Spent;

public interface SpentRepository extends CrudRepository<Spent, Integer>{
    
    @Query(value = "SELECT * FROM spent WHERE MONTH(date)=:month and YEAR(date)=:year ", nativeQuery=true)
    List<Spent> findByDate(int month, int year);
}
