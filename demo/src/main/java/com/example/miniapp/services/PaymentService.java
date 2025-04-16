package com.example.miniapp.services;

import com.example.miniapp.models.Payment;
import com.example.miniapp.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;
    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment addPayment(Payment payment)
    {
        return paymentRepository.save(payment);
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    //FIXME wont we lost valyes by typecasting into int?
    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id.intValue()).orElse(null);
    }

    public Payment updatePayment(Long id, Payment payment){
        Payment existingPayment = paymentRepository.findById(id.intValue()).orElse(null);
        if (existingPayment != null) {
            existingPayment.setAmount(payment.getAmount());
            existingPayment.setPaymentMethod(payment.getPaymentMethod());
            existingPayment.setPaymentStatus(payment.getPaymentStatus());
            return paymentRepository.save(existingPayment);
        }
        return null;
    }

    public void deletePayment(Long id) {
        paymentRepository.deleteById(id.intValue());
    }


    public List<Payment> findPaymentsByTripId(Long tripId)
    {
        //fixme to get list of payments
        return paymentRepository.findPaymentsByTrip(tripId);
    }

    public List<Payment> findByAmountThreshold(Double threshold)
    {
        //fixme to get list of payments
        return paymentRepository.findPaymentsByAmountGreaterThan(threshold);
    }









}
