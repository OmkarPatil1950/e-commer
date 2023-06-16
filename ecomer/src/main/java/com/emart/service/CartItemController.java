package com.emart.service;


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



@RestController  
@CrossOrigin("http://localhost:3000")
public class CartItemController
{
	@Autowired
	CartItemManager manager;
	
	
	 @GetMapping(value = "api/cartitems")
	 public List<cartitem> showcartitems()
	 {
		  return manager.getCartItems(); 
		
	 }
	
	 @GetMapping(value = "api/cartitemsById/{ctid}")
	 public Optional<cartitem> getcartitem(@PathVariable int ctid)
	 {
		Optional<cartitem> p=manager.getCartItem(ctid);
		return p;
	 }
	
	 @DeleteMapping(value = "api/cartitems/{ctid}")
	 public void removecartitem(@PathVariable int ctid)
	 {
		manager.delete(ctid);
	 }
	 @PutMapping(value = "api/cartitems/{ctid}")
	 public void updatecartitem(@RequestBody cartitem cartitem,@PathVariable int ctid)
	 {
		manager.update(cartitem,ctid);
	 }
	 @PostMapping(value = "api/cartitems")
	 public void addcartitem(@RequestBody cartitem cartitem)
	 {
		manager.addCartItem(cartitem);
	 }
}