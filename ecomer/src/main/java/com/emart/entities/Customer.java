package com.emart.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
    
    /**
     * Default constructor for the Customer class.
     */
    public Customer() {
        super();
    }
    
    private int customer_Id;
    private String username;
    private String password;
    private boolean prime_Customer;
    private int wallet;
    private String first_name;
    private String last_name;
    private String email_id;
    private String address;
    private String mobile_num;
    /**
     * Parameterized constructor for the Customer class.
     *
     * @param customer_Id     The customer ID.
     * @param username        The username.
     * @param password        The password.
     * @param prime_Customer  True if the customer is a prime customer, false otherwise.
     * @param wallet          The wallet balance.
     * @param first_name      The first name.
     * @param last_name       The last name.
     * @param email_id        The email ID.
     * @param address         The address.
     */
    
    public Customer(int customer_Id, String username, String password, boolean prime_Customer, int wallet,
            String first_name, String last_name, String email_id, String address, String mobile_num) {
        super();
        this.customer_Id = customer_Id;
        this.username = username;
        this.password = password;
        this.prime_Customer = prime_Customer;
        this.wallet = wallet;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email_id = email_id;
        this.address = address;
        this.mobile_num=mobile_num;
    }
    
    /**
     * Get the customer ID.
     *
     * @return The customer ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getcustomer_Id() {
        return customer_Id;
    }
    
    /**
     * Set the customer ID.
     *
     * @param customer_Id The customer ID to set.
     */
    public void setcustomer_Id(int customer_Id) {
        this.customer_Id = customer_Id;
    }
    
    /**
     * Get the username.
     *
     * @return The username.
     */
    public String getusername() {
        return username;
    }
    
    /**
     * Set the username.
     *
     * @param username The username to set.
     */
    public void setusername(String username) {
        this.username = username;
    }
    
    /**
     * Get the password.
     *
     * @return The password.
     */
    public String getpassword() {
        return password;
    }
    
    /**
     * Set the password.
     *
     * @param password The password to set.
     */
    public void setpassword(String password) {
        this.password = password;
    }
    
    /**
     * Check if the customer is a prime customer.
     *
     * @return True if the customer is a prime customer, false otherwise.
     */
    public boolean getprime_Customer() {
        return prime_Customer;
    }
    
    /**
     * Set whether the customer is a prime customer.
     *
     * @param prime_Customer True if the customer is a prime customer, false otherwise.
     */
    public void setprime_Customer(boolean prime_Customer) {
        this.prime_Customer = prime_Customer;
    }
    
    /**
     * Get the wallet balance of the customer.
     *
     * @return The wallet balance.
     */
    public int getwallet() {
        return wallet;
    }
    
    /**
     * Set the wallet balance of the customer.
     *
     * @param wallet The wallet balance to set.
     */
    public void setwallet(int wallet) {
        this.wallet = wallet;
    }
    
    /**
     * Get the first name of the customer.
     *
     * @return The first name.
     */
    public String getfirst_name() {
        return first_name;
    }
    
    /**
     * Set the first name of the customer.
     *
     * @param first_name The first name to set.
     */
    public void setfirst_name(String first_name) {
        this.first_name = first_name;
    }
    
    /**
     * Get the last name of the customer.
     *
     * @return The last name.
     */
    public String getlast_name() {
        return last_name;
    }
    
    /**
     * Set the last name of the customer.
     *
     * @param last_name The last name to set.
     */
    public void setlast_name(String last_name) {
        this.last_name = last_name;
    }
    
    /**
     * Get the email ID of the customer.
     *
     * @return The email ID.
     */
    public String getemail_id() {
        return email_id;
    }
    
    /**
     * Set the email ID of the customer.
     *
     * @param email_id The email ID to set.
     */
    public void setemail_id(String email_id) {
        this.email_id = email_id;
    }
    
    /**
     * Get the address of the customer.
     *
     * @return The address.
     */
    public String getaddress() {
        return address;
    }
    
    /**
     * Set the address of the customer.
     *
     * @param address The address to set.
     */
    public void setaddress(String address) {
        this.address = address;
    }
    
    public String getMobile_num() {
		return mobile_num;
	}

	public void setMobile_num(String mobile_num) {
		this.mobile_num = mobile_num;
	}

	@Override
    public String toString() {
        return "Customer [CustomerID=" + customer_Id + ", Username=" + username + ", Password=" + password
            + ", PrimeCustomer=" + prime_Customer + ", Wallet=" + wallet + ", FirstName=" + first_name
            + ", LastName=" + last_name + ", EmailId=" + email_id + ", Address=" + address + "]";
    }
	public void updateCustomer(int customer_Id, String username, String password, boolean prime_Customer, int wallet,
            String first_name, String last_name, String email_id, String address, String mobile_num) {
        this.customer_Id = customer_Id;
        this.username = username;
        this.password = password;
        this.prime_Customer = prime_Customer;
        this.wallet = wallet;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email_id = email_id;
        this.address = address;
        this.mobile_num = mobile_num;
    }
}
