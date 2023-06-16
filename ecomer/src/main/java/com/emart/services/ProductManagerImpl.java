package com.emart.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emart.entities.Category;
import com.emart.entities.Product;
import com.emart.repository.CategoryRepository;
import com.emart.repository.ProductRepository;

@Service
public class ProductManagerImpl implements ProductManager {

	@Autowired
	ProductRepository repository;

	/**
	 * Add a new product.
	 *
	 * @param p The product to be added.
	 */
	@Override
	public void addProduct(Product p) {
		System.out.println("product is " + p);
		repository.save(p);
	}

	/**
	 * Get all products.
	 *
	 * @return The list of products.
	 */
	@Override
	public List<Product> getProducts() {
		return repository.findAll();
	}

	/**
	 * Delete a product by ID.
	 *
	 * @param id The ID of the product to be deleted.
	 */
	@Override
	public void delete(int id) {
		repository.deleteById(id);
	}

	/**
	 * Get a product by ID.
	 *
	 * @param id The ID of the product.
	 * @return An optional containing the product, or an empty optional if not found.
	 */
	@Override
	public Optional<Product> getProduct(int id) {
		return repository.findById(id);
	}

//	/**
//	 * Get products by category ID.
//	 *
//	 * @param cat_Id The category ID.
//	 * @return The list of products.
//	 */
//	@Override
//	public List<Product> getProductByCat(int cat_Id) {
//		return repository.getProductsBySearch(cat_Id);
//	}

	/**
	 * Get products by search query.
	 *
	 * @param search The search query.
	 * @return The list of products.
	 */
	@Override
	public List<Product> getProductsBySearch(String search) {
		return repository.getProductsBySearch(search + "%");
	}

	/**
	 * Get products with promotions.
	 *
	 * @return The list of products with promotions.
	 */
	@Override
	public List<Product> getProductsByPromotion() {
		return repository.getProductsByPromotion();
	}

	@Override
	public List<Product> getProductsBySearch(int cat_Id) {
		return repository.getProducts(cat_Id);
	}

	@Override
	public List<Product> searchProducts(String search) {
		return repository.getProductsBySearch(search);
	}

	/**
	 * Check if a product exists for a given product ID.
	 *
	 * @param pid The product ID.
	 * @return true if the product exists, false otherwise.
	 */
	@Override
	public boolean exists(int pid) {
		return false;
	}
	
	@Override
	public void update(Product product,int id) {
		// TODO Auto-generated method stub
		System.out.println("inside update method of service layer");
		repository.update(product.getP_Name(),product.getP_Price(),product.getP_Image(),id);
	} 
}
