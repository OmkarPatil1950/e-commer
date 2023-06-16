package com.emart.services;

import java.util.List;
import java.util.Optional;

import com.emart.entities.Payment;

public interface PaymentManager {
	
	/**
	 * Add a new payment.
	 * 
	 * @param p The payment to be added.
	 */
	void addPayment(Payment p);
	
	/**
	 * Get all payments.
	 * 
	 * @return The list of payments.
	 */
	List<Payment> getPayments();
	
	/**
	 * Delete a payment by ID.
	 * 
	 * @param payment_Id The ID of the payment to be deleted.
	 */
	void delete(int payment_Id);
	
	// void update(Payment Payment, int payment_Id);

	/**
	 * Get a payment by ID.
	 * 
	 * @param payment_Id The ID of the payment.
	 * @return An optional containing the payment, or an empty optional if not found.
	 */
	Optional<Payment> getPayment(int payment_Id);
	
	// List<Payment> getSelected(String cat);
	
	/**
	 * Check if a payment exists by ID.
	 * 
	 * @param payment_Id The ID of the payment.
	 * @return True if the payment exists, false otherwise.
	 */
	boolean exists(int payment_Id);
}
