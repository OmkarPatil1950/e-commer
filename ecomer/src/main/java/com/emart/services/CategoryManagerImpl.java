package com.emart.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emart.entities.Category;
import com.emart.repository.CategoryRepository;

@Service
public class CategoryManagerImpl implements CategoryManager {

	@Autowired
	CategoryRepository repository;

	/**
	 * Add a new category.
	 * 
	 * @param category The category to be added.
	 */
	@Override
	public void addCategory(Category category) {
		repository.save(category);
	}

	/**
	 * Get all categories.
	 * 
	 * @return The list of categories.
	 */
	@Override
	public List<Category> getCategories() {
		return repository.listCategory();
	}

	/**
	 * Delete a category by ID.
	 * 
	 * @param id The ID of the category to be deleted.
	 */
	@Override
	public void delete(int id) {
		repository.deleteById(id);
	}

	/**
	 * Get a category by ID.
	 * 
	 * @param id The ID of the category.
	 * @return An optional containing the category, or an empty optional if not found.
	 */
	@Override
	public Optional<Category> getCategory(int id) {
		return repository.findById(id);
	}

	/*
	// Update a category by ID
	@Override
	public void update(Category category, int id) {
		System.out.println("inside update method of service layer");
		repository.update(category.getCategory_Name(), category.getParentcategory_Id(),
				category.getCategory_Img_Path(), category.isFlag(), id);
	}
	*/

	
	@Override
	public void update(Category category,int id) {
		// TODO Auto-generated method stub
		System.out.println("inside update method of service layer");
		repository.update(category.getCategory_Name(),category.getParentcategory_Id(),category.getCategory_Img_Path(),category.isFlag(),id);
	} 

	
	/**
	 * Get selected categories.
	 * 
	 * @return The list of selected categories.
	 */
	@Override
	public List<Category> getSelectedCat() {
		return repository.listCategory();
	}

	/**
	 * Get subcategories by parent category ID.
	 * 
	 * @param category_Id The ID of the parent category.
	 * @return The list of subcategories.
	 */
	@Override
	public List<Category> getSubCategories(int category_Id) {
		return repository.getSubCategories(category_Id);
	}

	/**
	 * Check if a category exists by ID.
	 * 
	 * @param cid The ID of the category.
	 * @return True if the category exists, false otherwise.
	 */
	@Override
	public boolean categoryExists(int cid) {
		return false;
	}
	@Override
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		return repository.findAll();
		
		
	}
}
