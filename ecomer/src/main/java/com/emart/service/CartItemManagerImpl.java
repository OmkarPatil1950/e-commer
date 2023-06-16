package com.emart.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CartItemManagerImpl implements CartItemManager{
	@Autowired
	CartItemRepository repository;

	@Override
	public void addCartItem(cartitem p) {
		// TODO Auto-generated method stub
		repository.save(p);
		
	}

	@Override
	public List<cartitem> getCartItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(cartitem cartitem, int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<cartitem> getCartItem(int id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}


}
