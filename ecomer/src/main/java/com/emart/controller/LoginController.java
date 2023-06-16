package com.emart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emart.entities.Admin;
import com.emart.entities.Customer;
//import com.emart.entities.Login;
import com.emart.services.AdminService;
import com.emart.services.CustomerManager;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = {"http://localhost:3000", "https://react-app3-route-omkar-07-dev.apps.sandbox-m3.1530.p1.openshiftapps.com" , "https://react-app3-route-omkar-07-dev.apps.sandbox-m4.g2pi.p1.openshiftapps.com"})
public class LoginController {

	@Autowired
	private AdminService adminService;

	@Autowired
	private CustomerManager customerManager;
	

	
	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	/**
	 * Authenticates the admin user.
	 *
	 * @param admin The admin object containing login credentials.
	 * @return ResponseEntity with the authentication status.
	 */
	@PostMapping("/admin")
	public ResponseEntity<?> authenticateAdmin(@RequestBody Admin admin) {
		return ResponseEntity.status(200).body(adminService.authenticateAdmin(admin));
	}

	/**
	 * Authenticates the customer user.
	 *
	 * @param customer The customer object containing login credentials.
	 * @return ResponseEntity with the authentication status.
	 */
//	@PostMapping("/customer")
//	public ResponseEntity<?> authenticateCustomer(@RequestBody String customer) {
//		System.out.println("In the login controller");
//		return ResponseEntity.status(200).body(customerManager.authenticateCustomer(customer));
//	}
	
	@PostMapping("/customer")
    public ResponseEntity<String> login(@RequestBody Login loginForm) {
        String email = loginForm.getemail_id();
        String password = loginForm.getPassword();
        System.out.println(email);
        System.out.println("password from ui");
        System.out.println(password);
System.out.println("----------------------------login-----------------------");
        // Perform your login logic here
        // Validate the email and password against your database or any other authentication mechanism
        
        if (isValidCredentials(email, password)) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }
    
    private boolean isValidCredentials(String email, String password) {
       
        // Return true if the credentials are valid, otherwise return false
       
    	List<Customer> ls = customerManager.getCustomers();
//    	String pass=passwordEncoder.encode(password);\
    	
    	System.out.println("Password after encode");
    	
    	for (Customer customer : ls) {
    		System.out.println(customer.getemail_id());
    		System.out.println(customer.getpassword());
			if((email.equals(customer.getemail_id())) && bCryptPasswordEncoder.matches(password, customer.getpassword())) {
				System.out.println("Mached");
				return true;
			}	
		}
    	return false;
}
}