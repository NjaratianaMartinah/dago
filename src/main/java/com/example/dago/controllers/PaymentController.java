package com.example.dago.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dago.models.Payment;
import com.example.dago.services.PaymentService;

@RestController("/payment")
public class PaymentController {
    

    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    /**
     * @param month the month's date of the payement
     * @param year the year's date of the payement
     * @return a list of Payment in one month
     */
    @GetMapping("/")
    public List<Payment> getMonthlyPayment(int month, int year){
        return paymentService.findMonthlyPayment();
    }

    /**
     * @param payment the new payment
     * @return the created payment
     */
    @PostMapping("/")
    public Payment create(Payment payment){
        payment.setDate(new Date());
        return paymentService.create(payment);
    }

}
