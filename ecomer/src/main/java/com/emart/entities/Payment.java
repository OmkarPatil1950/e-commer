package com.emart.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "payment")
public class Payment {
    
    private int payment_Id;
    private String payment_Type;
    private double amount;
    private Orders Orders;
    
    /**
     * Get the associated orders.
     *
     * @return The orders.
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_Id")
    public Orders getOrders() {
        return Orders;
    }
    
    /**
     * Set the associated orders.
     *
     * @param orders The orders to set.
     */
    public void setOrders(Orders orders) {
        Orders = orders;
    }
    
    /**
     * Default constructor.
     */
    public Payment() {
        super();
    }
    
    /**
     * Parameterized constructor.
     *
     * @param payment_Id    The payment ID.
     * @param payment_Type  The payment type.
     * @param amount        The payment amount.
     * @param orders        The associated orders.
     */
    public Payment(int payment_Id, String payment_Type, double amount, Orders orders) {
        super();
        this.payment_Id = payment_Id;
        this.payment_Type = payment_Type;
        this.amount = amount;
        Orders = orders;
    }
    
    /**
     * Get the payment ID.
     *
     * @return The payment ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getpayment_Id() {
        return payment_Id;
    }
    
    /**
     * Set the payment ID.
     *
     * @param payment_Id The payment ID to set.
     */
    public void setpayment_Id(int payment_Id) {
        this.payment_Id = payment_Id;
    }
    
    /**
     * Get the payment type.
     *
     * @return The payment type.
     */
    public String getpayment_Type() {
        return payment_Type;
    }
    
    /**
     * Set the payment type.
     *
     * @param payment_Type The payment type to set.
     */
    public void setpayment_Type(String payment_Type) {
        this.payment_Type = payment_Type;
    }
    
    /**
     * Get the payment amount.
     *
     * @return The payment amount.
     */
    public double getamount() {
        return amount;
    }
    
    /**
     * Set the payment amount.
     *
     * @param amount The payment amount to set.
     */
    public void setamount(double amount) {
        this.amount = amount;
    }
    
    @Override
    public String toString() {
        return "Product [payment_Id=" + payment_Id + ", payment_Type=" + payment_Type + ", amount=" + amount + "]";
    }
}
