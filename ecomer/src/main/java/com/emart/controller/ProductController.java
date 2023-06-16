package com.emart.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emart.entities.Category;
import com.emart.entities.Product;
import com.emart.exception.ProductNotFoundException;
import com.emart.services.CategoryManager;
import com.emart.services.ProductManager;

/**
 * The ProductController class handles the API endpoints related to Product operations.
 */
@RestController
@CrossOrigin(origins = {"http://localhost:3000", "https://react-app3-route-omkar-07-dev.apps.sandbox-m3.1530.p1.openshiftapps.com" , "https://react-app3-route-omkar-07-dev.apps.sandbox-m4.g2pi.p1.openshiftapps.com"})
public class ProductController {

    @Autowired
    ProductManager manager;

    /**
     * Get all products
     *
     * @return List of products
     */
    @GetMapping(value = "api/products")
    public List<Product> showProducts() {
        return manager.getProducts();
    }

    /**
     * Get product by ID
     *
     * @param pid Product ID
     * @return Optional of Product
     * @throws ProductNotFoundException if product is not found
     */
    @GetMapping(value = "api/productsById/{pid}")
    public Optional<Product> getProduct(@PathVariable int pid) {
        Optional<Product> product = manager.getProduct(pid);
        if (product.isPresent()) {
            return product;
        } else {
            throw new ProductNotFoundException("Product not found with ID: " + pid);
        }
    }

    /**
     * Remove product by ID
     *
     * @param pid Product ID
     * @throws ProductNotFoundException if product is not found
     */
    @DeleteMapping(value = "api/products/{pid}")
    public void removeProduct(@PathVariable int pid) {
        if (!manager.exists(pid)) {
            throw new ProductNotFoundException("Product not found with ID: " + pid);
        }
        manager.delete(pid);
    }

    /**
     * Add a new product
     *
     * @param product Product object
     */
    @PostMapping(value = "api/products")
    public void addProduct(@RequestBody Product product) {
        System.out.println("addProduct called");
        manager.addProduct(product);
    }

    /**
     * Get products by category ID
     *
     * @param cat_Id Category ID
     * @return List of products
     * @throws ProductNotFoundException if no products found for the specified category
     */
    @GetMapping(value = "api/productsByCat/{cat_Id}")
    public List<Product> getProductsByCategory(@PathVariable int cat_Id) {
        List<Product> products = manager.getProductsBySearch(cat_Id);
        if (products.isEmpty()) {
            throw new ProductNotFoundException("No products found for category ID: " + cat_Id);
        }
        return products;
    }

    /**
     * Search products by keyword
     *
     * @param search Search keyword
     * @return List of products
     * @throws ProductNotFoundException if no products found for the specified keyword
     */
    @GetMapping(value = "api/search/{search}")
    public List<Product> searchProducts(@PathVariable String search) {
        List<Product> products = manager.searchProducts(search);
        if (products.isEmpty()) {
            throw new ProductNotFoundException("No products found for search keyword: " + search);
        }
        return products;
    }

    /**
     * Get products by promotion
     *
     * @return List of products
     * @throws ProductNotFoundException if no products found with promotion
     */
    @GetMapping(value = "api/promotion")
    public List<Product> getProductsByPromotion() {
        List<Product> products = manager.getProductsByPromotion();
        if (products.isEmpty()) {
            throw new ProductNotFoundException("No products found with promotion");
        }
        return products;
    }

    @PutMapping(value = "api/products/{cid}")
	 public void updatepro(@RequestBody Product product,@PathVariable int pid)
	 {
		System.out.println("inside updatepro of controller");
		manager.update(product,pid);
	 }
}


