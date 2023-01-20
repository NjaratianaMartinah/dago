package com.example.dago.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.dago.models.Payment;
import com.example.dago.repositories.PaymentRepository;

@Service
public class PaymentService {
    
    private PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository){
        this.paymentRepository = paymentRepository;
    }

    public List<Payment> findMonthlyPayment(int month, int year){
        return (List<Payment>) paymentRepository.findByDate(month, year);
    }

    public Payment create(Payment payment){
        return paymentRepository.save(payment);
    }

    public Payment update(Payment payment, int paymentId) throws Exception{
        if(paymentRepository.findById(paymentId).isPresent()){
            payment.setId(paymentId); 
            payment.setDiffCounter();
            paymentRepository.save(payment);
            return payment;
        }
        throw new Exception("Ressource not found with id" + paymentId);
    }
}
