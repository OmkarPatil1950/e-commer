package com.emart.service;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="cartitem")
public class cartitem {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int cart_Item_Id;
private int quantity;
private double prime_CustomerPrice;

private int p_Id;

private int cart_Id;

public cartitem() {
	super();
}

public cartitem(int cart_Item_Id, int quantity, double prime_CustomerPrice, int p_Id,int cart_Id) {
	super();
	this.cart_Item_Id = cart_Item_Id;
	this.quantity = quantity;

	this.prime_CustomerPrice = prime_CustomerPrice;
	this.p_Id = p_Id;
	this.cart_Id = cart_Id;
}

public int getP_Id() {
	return p_Id;
}
public void setP_Id(int p_Id) {
	this.p_Id = p_Id;
}
public int getCart_Item_Id() {
	return cart_Item_Id;
}
public void setCart_Item_Id(int cart_Item_Id) {
	this.cart_Item_Id = cart_Item_Id;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}

public double getPrime_CustomerPrice() {
	return prime_CustomerPrice;
}

public void setPrime_CustomerPrice(double prime_CustomerPrice) {
	this.prime_CustomerPrice = prime_CustomerPrice;
}


public int getCart_Id() {
	return cart_Id;
}

public void setCart_Id(int cart_Id) {
	this.cart_Id = cart_Id;
}

@Override
public String toString() {
	return "CartItem [cart_Item_Id=" + cart_Item_Id + ", quantity=" + quantity  +", product=" + p_Id + "]";
}




}