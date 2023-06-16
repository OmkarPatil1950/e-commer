package com.emart.services;

import java.util.List;
import java.util.Optional;

import com.emart.entities.Category;

/**
 * Interface for managing categories.
 */
public interface CategoryManager {
	
	/**
	 * Adds a category to the system.
	 *
	 * @param category The category to be added.
	 */
	void addCategory(Category category);
	
	/**
	 * Retrieves all categories from the system.
	 *
	 * @return The list of all categories.
	 */
	List<Category> getCategories();
	
	/**
	 * Deletes a category from the system by its ID.
	 *
	 * @param id The ID of the category to be deleted.
	 */
	void delete(int id);
	
	//void update(Category category,int id);
	
	/**
	 * Retrieves a category by its ID from the system.
	 *
	 * @param id The ID of the category.
	 * @return The optional category if found, or an empty optional if not found.
	 */
	Optional<Category> getCategory(int id);
	
	/**
	 * Retrieves the selected categories from the system.
	 *
	 * @return The list of selected categories.
	 */
	List<Category> getSelectedCat();
	
	/**
	 * Retrieves the subcategories of a category.
	 *
	 * @param category_Id The ID of the parent category.
	 * @return The list of subcategories.
	 */
	List<Category> getSubCategories(int category_Id);
	
	/**
	 * Checks if a category exists in the system by its ID.
	 *
	 * @param cid The ID of the category.
	 * @return `true` if the category exists, `false` otherwise.
	 */
	boolean categoryExists(int cid);

	void update(Category category, int id);

	List<Category> getAllCategories();
}
