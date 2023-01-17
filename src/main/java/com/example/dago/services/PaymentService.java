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

    public List<Payment> findMonthlyPayment(){
        return (List<Payment>) paymentRepository.findByDate(0, 0);
    }

    public Payment create(Payment payment){
        return paymentRepository.save(payment);
    }
}
