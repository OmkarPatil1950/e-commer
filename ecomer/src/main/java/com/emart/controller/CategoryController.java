package com.emart.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emart.entities.Category;
import com.emart.exception.CategoryNotFoundException;
import com.emart.services.CategoryManager;

/**
 * The CategoryController class handles the API endpoints related to category operations.
 */
@RestController
@CrossOrigin(origins = {"http://localhost:3000", "https://react-app3-route-omkar-07-dev.apps.sandbox-m3.1530.p1.openshiftapps.com" , "https://react-app3-route-omkar-07-dev.apps.sandbox-m4.g2pi.p1.openshiftapps.com"})
public class CategoryController {

    @Autowired
    CategoryManager manager;

    /**
     * Retrieves a specific category by its ID.
     *
     * @param cid The ID of the category to retrieve.
     * @return ResponseEntity with the Category if found,
     *         or throws CategoryNotFoundException if the category is not found.
     */
    @GetMapping(value = "api/categoriesById/{cid}")
    public ResponseEntity<Category> getCategory(@PathVariable int cid) {
        Optional<Category> category = manager.getCategory(cid);
        return category.map(ResponseEntity::ok).orElseThrow(() ->
                new CategoryNotFoundException("Category not found with cid: " + cid));
    }

    /**
     * Retrieves all the categories.
     *
     * @return ResponseEntity with the list of Category objects if they exist,
     *         or a no content response if no categories are found.
     */
    @GetMapping(value = "api/Categories")
    public ResponseEntity<List<Category>> getCategories() {
        List<Category> categories = manager.getCategories();
        if (categories.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(categories);
        }
    }

    /**
     * Retrieves the subcategories of a specific category.
     *
     * @param c_Id The ID of the parent category.
     * @return List of Category objects representing the subcategories.
     * @throws CategoryNotFoundException if the parent category is not found.
     */
    @GetMapping(value = "api/subcategories/{c_Id}")
    public List<Category> getSubCategories(@PathVariable int c_Id) {
        List<Category> subCategories = manager.getSubCategories(c_Id);
        if (subCategories.isEmpty()) {
            throw new CategoryNotFoundException("Subcategories not found for category with c_Id: " + c_Id);
        }
        return subCategories;
    }

    /**
     * Removes a category by its ID.
     *
     * @param cid The ID of the category to remove.
     * @throws CategoryNotFoundException if the category is not found.
     */
    @DeleteMapping(value = "api/categories/{cid}")
    public void removeCategory(@PathVariable int cid) {
        if (!manager.categoryExists(cid)) {
            throw new CategoryNotFoundException("Category not found with cid: " + cid);
        }
        manager.delete(cid);
    }

    /**
     * Adds a new category.
     *
     * @param category The Category object to add.
     */
    @PostMapping(value = "api/categories")
    public void addCategory(@RequestBody Category category) {
        manager.addCategory(category);
    }
}
