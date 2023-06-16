package com.emart.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emart.entities.Cart;
import com.emart.entities.Customer;
import com.emart.repository.CartRepository;

/**
 * Implementation of the CartManager interface.
 */
@Service
public class CartManagerImpl implements CartManager {
	
	@Autowired
	private CartRepository repository;

	
	/**
	 * Adds a cart to the repository.
	 *
	 * @param cart The cart to be added.
	 */
	@Override
	public void addToCart(Cart cart) {
		System.out.println("save");
		repository.save(cart);
	}

	/**
	 * Retrieves all carts from the repository.
	 *
	 * @return The list of all carts.
	 */
	@Override
	public List<Cart> getAllCart() {
		return repository.findAll();
	}

	/**
	 * Retrieves a cart by its ID from the repository.
	 *
	 * @param cartId The ID of the cart.
	 * @return The optional cart if found, or an empty optional if not found.
	 */
	@Override
	public Optional<Cart> getById(int cartId) {
		return repository.findById(cartId);
	}

	/**
	 * Deletes a cart from the repository by its ID.
	 *
	 * @param cartId The ID of the cart to be deleted.
	 */
	@Override
	public void deleteFromCart(int cartId) {
		repository.deleteById(cartId);
	}

	@Override
	public List<Object[]> getByCustId(int cart_Id) {
		// TODO Auto-generated method stub
		return repository.getCartItems(cart_Id);
	}

	@Override
	public List<Cart> getAllCarts() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}


//	public List<Cart> getByCustId(int cart_Id) {
//		// TODO Auto-generated method stub
//		return repository.getCartItems();
//	}

	
}
