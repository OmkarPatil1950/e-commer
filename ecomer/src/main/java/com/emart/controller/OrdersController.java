package com.emart.controller;

import java.util.Arrays;
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

import com.emart.entities.Cart;
import com.emart.entities.Orders;
import com.emart.exception.OrdersNotFoundException;
import com.emart.services.OrdersManager;

/**
 * The OrdersController class handles the API endpoints related to Orders operations.
 */
@RestController
@CrossOrigin(origins = {"http://localhost:3000", "https://react-app3-route-omkar-07-dev.apps.sandbox-m3.1530.p1.openshiftapps.com" , "https://react-app3-route-omkar-07-dev.apps.sandbox-m4.g2pi.p1.openshiftapps.com"})
public class OrdersController {

    @Autowired
    public OrdersManager manager;

   /*
     * Adds a new order.
     *
     * @param orders The Orders object to add.
     */
    @PostMapping("api/addorders/{id}")
    public void addOrd(@PathVariable("id") Cart cartId[], @RequestBody Orders orders) {
        System.out.println("Post mapping for orders");
            
        System.out.println(Arrays.toString(cartId));
        for (Cart i : cartId) {
            System.out.println("for loop");
            System.out.println(i);
            Orders newOrders = new Orders(); // Create a new Orders object for each iteration
            newOrders.setCart(i);
            newOrders.setOrder_Date(orders.getOrder_Date());
            newOrders.setOrder_Total(orders.getOrder_Total());
            // Assuming manager.addOrders creates a new entry in the database
            manager.addOrders(newOrders);
        }
    }



    /**
     * Retrieves all orders.
     *
     * @return List of Orders objects.
     */
    @GetMapping("api/orders")
    public List<Orders> getAllOrd() {
        return manager.getAllOrders();
    }

    /**
     * Retrieves a specific order by its ID.
     *
     * @param order_Id The ID of the order to retrieve.
     * @return Optional containing the Orders if found, or throws OrdersNotFoundException if not found.
     */
    @GetMapping("api/orders/{customer_Id}")
    public List<Object[]> getOrd(@PathVariable int customer_Id) {
    	System.out.println(customer_Id);
        return manager.getOrders(customer_Id);
        
    }

    /**
     * Deletes an order by its ID.
     *
     * @param order_Id The ID of the order to delete.
     * @throws OrdersNotFoundException if the order is not found.
     */
    @DeleteMapping("api/delete/{order_Id}")
    public void del(@PathVariable int order_Id) {
        if (!manager.exists(order_Id)) {
            throw new OrdersNotFoundException("Order not found with order_Id: " + order_Id);
        }
        manager.delete(order_Id);
    }
}
