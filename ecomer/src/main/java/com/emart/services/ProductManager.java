package com.emart.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.emart.entities.Category;
import com.emart.entities.Product;

public interface ProductManager {
	
	/**
	 * Add a new product.
	 *
	 * @param p The product to be added.
	 */
	void addProduct(Product p);
	
	/**
	 * Get all products.
	 *
	 * @return The list of products.
	 */
	List<Product> getProducts();
	
	/**
	 * Delete a product by ID.
	 *
	 * @param id The ID of the product to be deleted.
	 */
	void delete(int id);
	
	/**
	 * Get a product by ID.
	 *
	 * @param id The ID of the product.
	 * @return An optional containing the product, or an empty optional if not found.
	 */
	Optional<Product> getProduct(int id);
	
//	/**
//	 * Get products by category ID.
//	 *
//	 * @param cat_Id The category ID.
//	 * @return The list of products.
//	 */
//	List<Product> getProductByCat(int cat_Id);
//	
	/**
	 * Get products by search query.
	 *
	 * @param cat_Id The category ID for filtering.
	 * @return The list of products.
	 */
	List<Product> getProductsBySearch(int cat_Id);
	
	/**
	 * Get products with promotions.
	 *
	 * @return The list of products with promotions.
	 */
	List<Product> getProductsByPromotion();
	
	/**
	 * Search products by name or description.
	 *
	 * @param search The search query.
	 * @return The list of products matching the search query.
	 */
	List<Product> searchProducts(String search);
	
	/**
	 * Get products by search query.
	 *
	 * @param search The search query.
	 * @return The list of products.
	 */
	List<Product> getProductsBySearch(String search);
	
	/**
	 * Check if a product exists for a given product ID.
	 *
	 * @param pid The product ID.
	 * @return true if the product exists, false otherwise.
	 */
	boolean exists(int pid);
	
	void update(Product product, int id);
}
