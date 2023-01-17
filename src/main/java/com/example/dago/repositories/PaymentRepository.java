package com.example.dago.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.example.dago.models.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Integer> {

    @Query(value = "SELECT * FROM payment WHERE MONTH(date)=:month and YEAR(date)=:year ", nativeQuery=true)
    List<Payment> findByDate(int month, int year);

}
