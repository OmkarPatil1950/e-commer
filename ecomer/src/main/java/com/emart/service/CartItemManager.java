package com.emart.service;

import java.util.List;
import java.util.Optional;



public interface CartItemManager {
	void addCartItem(cartitem p);
	List<cartitem> getCartItems();
	void delete(int id);
	void update(cartitem cartitem,int id);
	Optional<cartitem> getCartItem(int id);
}
