package com.emart.entities;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "total_Cost")
    private Double totalCost;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_Id")
    private Customer customer;

    private int quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "p_id")
    private Product product;

    public Cart() {
        super(); // Call the superclass constructor (if applicable)
    }

    /**
     * Constructs a Cart object with the specified details.
     *
     * @param id         The ID of the cart.
     * @param totalCost  The total cost of the cart.
     * @param customer   The customer associated with the cart.
     * @param quantity   The quantity of the cart.
     * @param product    The product associated with the cart.
     */
    public Cart(int id, Double totalCost, Customer customer, int quantity, Product product) {
        super(); // Call the superclass constructor (if applicable)
        this.id = id; // Set the ID of the cart
        this.totalCost = totalCost; // Set the total cost of the cart
        this.customer = customer; // Set the customer associated with the cart
        this.quantity = quantity; // Set the quantity of the cart
        this.product = product; // Set the product associated with the cart
    }

    /**
     * Gets the ID of the cart.
     *
     * @return The cart ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the cart.
     *
     * @param id The cart ID to set.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the total cost of the cart.
     *
     * @return The total cost.
     */
    public Double getTotalCost() {
        return totalCost;
    }

    /**
     * Sets the total cost of the cart.
     *
     * @param totalCost The total cost to set.
     */
    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    /**
     * Gets the customer associated with the cart.
     *
     * @return The customer.
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Sets the customer associated with the cart.
     *
     * @param customer The customer to set.
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * Gets the quantity of the cart.
     *
     * @return The quantity.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the cart.
     *
     * @param quantity The quantity to set.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Gets the product associated with the cart.
     *
     * @return The product.
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Sets the product associated with the cart.
     *
     * @param product The product to set.
     */
    public void setProduct(Product product) {
        this.product = product;
    }

	@Override
	public String toString() {
		return "Cart [id=" + id + ", totalCost=" + totalCost + ", customer=" + customer + ", quantity=" + quantity
				+ ", product=" + product + "]";
	}
    
}