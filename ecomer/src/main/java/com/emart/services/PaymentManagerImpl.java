package com.emart.services;

import java.util.List;
import java.util.Optional; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emart.entities.Payment;
import com.emart.repository.PaymentRepository;

@Service
public class PaymentManagerImpl implements PaymentManager {
	
	@Autowired
	PaymentRepository repository;

	/**
	 * Add a new payment.
	 * 
	 * @param p The payment to be added.
	 */
	@Override
	public void addPayment(Payment p) {
		repository.save(p);
	}

	/**
	 * Get all payments.
	 * 
	 * @return The list of payments.
	 */
	@Override
	public List<Payment> getPayments() {
		return repository.findAll();
	}

	/**
	 * Delete a payment by ID.
	 * 
	 * @param payment_Id The ID of the payment to be deleted.
	 */
	@Override
	public void delete(int payment_Id) {
		repository.deleteById(payment_Id);
	}

	// @Override
	// public void update(Product product, int id) {
	//     System.out.println("inside update method of service layer");
	//     repository.update(product.getProname(), product.getCategory(), product.getPrice(), product.getQuantity(), id);
	// }

	/**
	 * Get a payment by ID.
	 * 
	 * @param payment_Id The ID of the payment.
	 * @return An optional containing the payment, or an empty optional if not found.
	 */
	@Override
	public Optional<Payment> getPayment(int payment_Id) {
		return repository.findById(payment_Id);
	}

	/**
	 * Check if a payment exists by ID.
	 * 
	 * @param payment_Id The ID of the payment.
	 * @return True if the payment exists, false otherwise.
	 */
	@Override
	public boolean exists(int payment_Id) {
		return false;
	}

	// @Override
	// public List<Product> getSelected(String cat) {
	//     return repository.listCat(cat);
	// }
}
