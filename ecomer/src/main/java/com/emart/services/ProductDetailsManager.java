package com.emart.services;

import java.util.List;
import java.util.Optional;

import com.emart.entities.Category;
import com.emart.entities.ProductDetails;

public interface ProductDetailsManager {
	
	/**
	 * Add a new product details.
	 * 
	 * @param c The product details to be added.
	 */
	void addProductDetails(ProductDetails c);
	
	/**
	 * Get all product details.
	 * 
	 * @return The list of product details.
	 */
	List<ProductDetails> getProductDetails();
	
	/**
	 * Delete product details by ID.
	 * 
	 * @param id The ID of the product details to be deleted.
	 */
	void delete(int id);
	
	/**
	 * Get product details by ID.
	 * 
	 * @param id The ID of the product details.
	 * @return An optional containing the product details, or an empty optional if not found.
	 */
	Optional<ProductDetails> getProductDetail(int id);
	
	/**
	 * Get product details by product ID.
	 * 
	 * @param product The product ID.
	 * @return The list of product details for the given product.
	 */
	List<ProductDetails> getDetails(int product);
	
	/**
	 * Check if product details exist by ID.
	 * 
	 * @param cid The ID of the product details.
	 * @return True if the product details exist, false otherwise.
	 */
	boolean exists(int cid);
	
	void update(ProductDetails product, int id);
}
