package com.emart.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.emart.entities.Customer;

public interface CustomerManager {
	
	/**
	 * Add a new customer.
	 * 
	 * @param c The customer to be added.
	 * @return 
	 */
	Customer addCustomer(Customer c);
	
	/**
	 * Get all customers.
	 * 
	 * @return The list of customers.
	 */
	List<Customer> getCustomers();
	
	/**
	 * Delete a customer by ID.
	 * 
	 * @param customer_Id The ID of the customer to be deleted.
	 */
	void delete(int customer_Id);
	
	/**
	 * Update the wallet balance of a customer.
	 * 
	 * @param customer_Id The ID of the customer.
	 * @param wallet The new wallet balance.
	 */
	void updateWallet(int customer_Id, int wallet);
	
	/**
	 * Get a customer by ID.
	 * 
	 * @param customer_Id The ID of the customer.
	 * @return An optional containing the customer, or an empty optional if not found.
	 */
	Optional<Customer> getCustomer(int customer_Id);
	
	/**
	 * Get a customer by username.
	 * 
	 * @param username The username of the customer.
	 * @return An optional containing the customer, or an empty optional if not found.
	 */
	Optional<Object> getCustomer(String username);
	
	ResponseEntity<String> authenticateCustomer(String customer);

	List<Customer> getCustomerbyEmail(String email_id);
}
