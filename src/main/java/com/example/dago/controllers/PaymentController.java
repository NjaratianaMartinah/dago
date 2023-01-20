package com.example.dago.controllers;

import java.util.Date;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dago.models.Payment;
import com.example.dago.services.PaymentService;

@RestController
@RequestMapping("/payment")
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
    @GetMapping("/{month}/{year}")
    public List<Payment> getMonthlyPayment(@PathVariable int month, @PathVariable int year){
        return paymentService.findMonthlyPayment(month, year);
    }

    /**
     * @param payment the new payment
     * @return the created payment
     */
    @PostMapping("/")
    public Payment create(@RequestBody Payment payment){
        payment.setDate(new Date());
        payment.setDiffCounter();
        return paymentService.create(payment);
    }

    /**
     * @param payment the new value of the payment
     * @param payment the id  of the payment to update
     * @return the updated payment
     * @throws Exception
     */
    @PutMapping("/{id}")
    public Payment update(@RequestBody Payment payment, @PathVariable("id") int paymentId) throws Exception{
        try {
            return paymentService.update(payment, paymentId);
        } catch (Exception e) {
            throw e;
        }
    }

}
