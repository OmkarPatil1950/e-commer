package com.emart.services;

import java.util.List;
import java.util.Optional;

import com.emart.entities.Cart;
import com.emart.entities.Customer;

/**
 * Interface for managing Cart entities.
 */
public interface CartManager {
    
    /**
     * Add a cart to the system.
     *
     * @param cart The cart to add.
     */
    void addToCart(Cart cart);
    
    /**
     * Get all carts in the system.
     *
     * @return A list of carts.
     */
    List<Cart> getAllCart();
    
    /**
     * Get a cart by its ID.
     *
     * @param cartId The ID of the cart to retrieve.
     * @return An Optional containing the cart, or an empty Optional if not found.
     */
    Optional<Cart> getById(int cartId);
    
    /**
     * Delete a cart by its ID.
     *
     * @param cartId The ID of the cart to delete.
     */
    void deleteFromCart(int cartId);

	List<Object[]> getByCustId(int customerId);

	List<Cart> getAllCarts();

	
}
