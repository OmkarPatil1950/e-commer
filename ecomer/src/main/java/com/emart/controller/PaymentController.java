package com.emart.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emart.entities.Payment;
import com.emart.exception.PaymentNotFoundException;
import com.emart.services.PaymentManager;

/**
 * The PaymentController class handles the API endpoints related to Payment operations.
 */
@RestController  
@CrossOrigin(origins = {"http://localhost:3000", "https://react-app3-route-omkar-07-dev.apps.sandbox-m3.1530.p1.openshiftapps.com" , "https://react-app3-route-omkar-07-dev.apps.sandbox-m4.g2pi.p1.openshiftapps.com"})
public class PaymentController {

    @Autowired
    PaymentManager manager;

    /**
     * Retrieves all payments.
     *
     * @return List of Payment objects.
     */
    @GetMapping(value = "api/payment")
    public List<Payment> showPayments() {
        return manager.getPayments();
    }

    /**
     * Retrieves a specific payment by its ID.
     *
     * @param payment_Id The ID of the payment to retrieve.
     * @return Payment if found, or throws PaymentNotFoundException if the payment is not found.
     * @throws PaymentNotFoundException if the payment is not found.
     */
    @GetMapping("api/paymentById/{payment_Id}")
    public Payment getPayment(@PathVariable int payment_Id) {
        Optional<Payment> payment = manager.getPayment(payment_Id);
        return payment.orElseThrow(() ->
                new PaymentNotFoundException("Payment not found with payment ID: " + payment_Id));
    }

    /**
     * Removes a payment by its ID.
     *
     * @param payment_Id The ID of the payment to remove.
     * @throws PaymentNotFoundException if the payment is not found.
     */
    @DeleteMapping(value = "api/payment/{payment_Id}")
    public void removePayment(@PathVariable int payment_Id) {
        if (!manager.exists(payment_Id)) {
            throw new PaymentNotFoundException("Payment not found with payment ID: " + payment_Id);
        }
        manager.delete(payment_Id);
    }

    /**
     * Adds a new payment.
     *
     * @param payment The Payment object to add.
     */
    @PostMapping("api/payment")
    public void addPayment(@RequestBody Payment payment) {
        System.out.println("addPayment called");
        manager.addPayment(payment);
    }
}
