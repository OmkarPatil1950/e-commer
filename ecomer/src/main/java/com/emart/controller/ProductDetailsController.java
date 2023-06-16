package com.emart.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emart.entities.ProductDetails;
import com.emart.exception.ProductDetailsNotFoundException;
import com.emart.services.ProductDetailsManager;

/**
 * The ProductDetailsController class handles the API endpoints related to ProductDetails operations.
 */
@RestController
@CrossOrigin(origins = {"http://localhost:3000", "https://react-app3-route-omkar-07-dev.apps.sandbox-m3.1530.p1.openshiftapps.com" , "https://react-app3-route-omkar-07-dev.apps.sandbox-m4.g2pi.p1.openshiftapps.com"})
public class ProductDetailsController {

    @Autowired
    ProductDetailsManager manager;

    /**
     * Retrieve all product details.
     *
     * @return List of ProductDetails
     */
    @GetMapping(value = "api/productdetails")
    public List<ProductDetails> showProductDetails() {
        return manager.getProductDetails();
    }

    /**
     * Retrieve a specific product detail by ID.
     *
     * @param productDetail_Id ID of the product detail to retrieve
     * @return Optional containing the ProductDetails if found, or throws ProductDetailsNotFoundException if not found
     */
    @GetMapping(value = "api/productDetailsById/{productDetail_Id}")
    public Optional<ProductDetails> getProductDetail(@PathVariable int productDetail_Id) {
        Optional<ProductDetails> productDetails = manager.getProductDetail(productDetail_Id);
        if (productDetails.isPresent()) {
            return productDetails;
        } else {
            throw new ProductDetailsNotFoundException("Product details not found for ID: " + productDetail_Id);
        }
    }

    /**
     * Retrieve all product details for a specific product.
     *
     * @param p_Id ID of the product
     * @return List of ProductDetails for the specified product
     * @throws ProductDetailsNotFoundException if no product details found for the specified product
     */
    @GetMapping(value = "api/productdetails/{p_Id}")
    public List<ProductDetails> getDetails(@PathVariable int p_Id) {
        List<ProductDetails> productDetails = manager.getDetails(p_Id);
        if (productDetails.isEmpty()) {
            throw new ProductDetailsNotFoundException("No product details found for product ID: " + p_Id);
        }
        return productDetails;
    }

    /**
     * Delete a product detail by ID.
     *
     * @param cid ID of the product detail to delete
     * @throws ProductDetailsNotFoundException if product detail is not found
     */
    @DeleteMapping(value = "api/productdetails/{cid}")
    public void delete(@PathVariable int cid) {
        if (!manager.exists(cid)) {
            throw new ProductDetailsNotFoundException("Product details not found for ID: " + cid);
        }
        manager.delete(cid);
    }

    /**
     * Add a new product detail.
     *
     * @param prod ProductDetails object to add
     */
    @PostMapping(value = "api/productdetails")
    public void getProductDetails(@RequestBody ProductDetails prod) {
        System.out.println("addProductDetails called");
        manager.addProductDetails(prod);
    }
    
}
