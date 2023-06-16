//package com.emart.controller;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.Random;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.emart.entities.Customer;
//import com.emart.exception.CustomerNotFoundException;
//import com.emart.services.CustomerManager;
//
///**
// * The CustomerController class handles the API endpoints related to Customer operations.
// */
//@RestController
//@CrossOrigin(origins = {"http://localhost:3000", "https://react-app3-route-omkar-07-dev.apps.sandbox-m4.g2pi.p1.openshiftapps.com" , "https://react-app3-route-omkar-07-dev.apps.sandbox-m4.g2pi.p1.openshiftapps.com"})
//public class CustomerController {
//
//    @Autowired
//    CustomerManager manager;
//
//    @Autowired
//    private JavaMailSender mailSender;
//
//    public static int  randomNumber;
//    /**
//     * Retrieves all the customers.
//     *
//     * @return ResponseEntity with the list of Customer objects if they exist,
//     *         or a no content response if no customers are found.
//     */
//    @GetMapping(value = "api/customers/")
//    public ResponseEntity<List<Customer>> showCustomers() {
//        List<Customer> customers = manager.getCustomers();
//        if (customers.isEmpty()) {
//            return ResponseEntity.noContent().build();
//        } else {
//            return ResponseEntity.ok(customers);
//        }
//    }
//    @GetMapping(value = "api/getbyemail/{email_id}")
//    public List<Customer> getCustomerbyemail(@PathVariable String email_id) {
//		System.out.println("inside cust by email");
//    	System.out.println(manager.getCustomerbyEmail(email_id));
//    	return manager.getCustomerbyEmail(email_id); 
//    }
//    
//    /**
//     * Retrieves a specific customer by their ID.
//     *
//     * @param customer_Id The ID of the customer to retrieve.
//     * @return ResponseEntity with the Customer if found,
//     *         or throws CustomerNotFoundException if the customer is not found.
//     */
//    @GetMapping(value = "api/customerById/{customer_Id}")
//    public ResponseEntity<Customer> getCustomer(@PathVariable int customer_Id) {
//        try {
//            Optional<Customer> customer = manager.getCustomer(customer_Id);
//            return customer.map(ResponseEntity::ok).orElseThrow(() ->
//                    new CustomerNotFoundException("Customer not found with ID: " + customer_Id));
//        } catch (CustomerNotFoundException e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                    .body(null);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body(null);
//        }
//    }
//
//    /**
//     * Removes a customer by their ID.
//     *
//     * @param customer_Id The ID of the customer to remove.
//     * @return ResponseEntity with a success message if the customer is deleted successfully,
//     *         or an error message if the customer deletion fails.
//     */
//    @DeleteMapping(value = "api/customer/{customer_Id}")
//    public ResponseEntity<String> removeCustomer(@PathVariable int customer_Id) {
//        try {
//            manager.delete(customer_Id);
//            return ResponseEntity.ok("Customer deleted successfully.");
//        } catch (CustomerNotFoundException e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                    .body("Customer not found with ID: " + customer_Id);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Failed to delete customer: " + e.getMessage());
//        }
//    }
//
//    /**
//     * Updates a customer's wallet balance by their ID.
//     *
//     * @param customer     The updated Customer object.
//     * @param customer_Id  The ID of the customer to update.
//     * @return ResponseEntity with a success message if the customer is updated successfully,
//     *         or an error message if the customer update fails.
//     */
//    @PutMapping(value = "api/customer/{customer_Id}")
//    public ResponseEntity<String> updateCustomer(@RequestBody Customer customer, @PathVariable int customer_Id) {
//        try {
//            manager.updateWallet(customer_Id, customer.getwallet());
//            return ResponseEntity.ok("Customer updated successfully.");
//        } catch (CustomerNotFoundException e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                    .body("Customer not found with ID: " + customer_Id);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Failed to update customer: " + e.getMessage());
//        }
//    }
//
//    /**
//     * Adds a new customer.
//     *
//     * @param customer The Customer object to add.
//     * @return ResponseEntity with a success message if the customer is added successfully,
//     *         or an error message if the customer addition fails.
//     */
////    @PostMapping("/api/customer")
////	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
////		List<Customer> ls = (List<Customer>) showCustomers();
////		System.out.println(customer);
////		boolean flag = true;
////		try {
////			if (ls.size() == 0) {
////				System.out.println("0");
////				manager.addCustomer(customer);
////				Customer createdCustomer = manager.addCustomer(customer);
////				return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
////			} else {
////				System.out.println("inside for");
////				for (Customer customer2 : ls) {
////					if ((customer2.getemail_id().equals(customer.getemail_id())) || customer.getemail_id() == null) {
////						System.out.println("alerady exists");
////						flag = false;
////						System.out.println(customer2.getemail_id());
////						return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
////					}
////				}
////				if (flag == true) {
////					System.out.println("added sucessfully");
////					Customer createdCustomer = manager.addCustomer(customer);
////					return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
////				}
////
////			}
////		} catch (Exception e) {
////			System.out.println("catch");
////			System.out.println(e.toString());
////			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
////		}
////		System.out.println("outside");
////		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
////	}
//    @PostMapping(value = "api/customer")
//    public ResponseEntity<String> addCustomer(@RequestBody Customer customer) {
//       System.out.println("inside add customer");
//       boolean flag=false;
//    	try {
//    		 List<Customer> ls =manager.getCustomers();
//    	    	for (Customer c : ls) {	
//    	    		System.out.println(c.getemail_id());
//    	    		if(c.getemail_id().equals(customer.getemail_id())) {
//    	    			System.out.println("match");
//    	    			flag=true;
//    	    			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("email_id already exists");
//    	    		}
//    	    		
//    			}
//    	    	if(!flag) {
//    	    		ResponseEntity<String> s=sendEmail(customer.getemail_id());
//    	    		System.out.println(ResponseEntity.ok());
//    	    		System.out.println(s);
//    	    		int statusCode = s.getStatusCodeValue();
//    	    		System.out.println(statusCode);
//    	    		if(statusCode==200) {
//    	    			
//    	    		 manager.addCustomer(customer); 
//    	    		System.out.println("email send sucessfully");
//    	    		return ResponseEntity.ok("Customer added successfully.");
//    	    		}
//    	    		else {
//    	    			System.out.println("Inside else");
//    	    			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("not added");
//    	    		}
//      	    	}
//    	    	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("not added");
//           
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Failed to add customer: " + e.getMessage());
//        }
//    }
//    /**
//     * Retrieves a customer by their username.
//     *
//     * @param username The username of the customer to retrieve.
//     * @return ResponseEntity with the Customer if found,
//     *         or a no content response if the customer is not found.
//     */
////    @GetMapping(value = "api/getByUserName/{username}")
////    public ResponseEntity<Object> getCustomer(@PathVariable String username) {
////        try {
////            Optional<Object> customer = manager.getCustomer(username);
////            return customer.map(ResponseEntity::ok).orElse(ResponseEntity.noContent().build());
////        } catch (Exception e) {
////            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
////                    .body(null);
////        }
////    }
//    @PostMapping(value = "api/send-email")
//    public ResponseEntity<String> sendEmail(String email_id) {
//    	System.out.println("email");
//    	
//        try {
//            boolean shouldSendEmail = true; // Add your condition here to determine when to send the email
//             randomNumber = generateRandomNumber();
//            if (shouldSendEmail) {
//                SimpleMailMessage message = new SimpleMailMessage();
//                message.setTo(email_id);
//                message.setSubject("onestop Email");
//                System.out.println(randomNumber);
//                message.setText("This is a registration email sent from Spring Boot.");
//                message.setText("OTP is - "+randomNumber);
//                mailSender.send(message);
//                System.out.println("send sucessfully");
//                return ResponseEntity.ok("Email sent successfully.");
//            } else {
//            	 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                         .body("Failed to send email:");
//            }
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Failed to send email: " + e.getMessage());
//        }
//    }
//    public static int generateRandomNumber() {
//        Random random = new Random();
//        int min = 1000; // Minimum 6-digit number
//        int max = 9999; // Maximum 6-digit number
//        return random.nextInt(max - min + 1) + min;
//    }
//    @PostMapping("api/validateopt")
//    public static ResponseEntity<Boolean> validateOtp(@RequestBody String number) {
//    	
//    	System.out.println(number);
//    	System.out.println(randomNumber);
//        if (number.equals(randomNumber)) {
//        	System.out.println("if");
//            return ResponseEntity.ok(true); // Number is valid, return HTTP 200 OK with "true" body
//        } else {
//        	System.out.println("else");
//        	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body(false);
//       // Number is invalid, return HTTP 200 OK with "false" body
//        }
//    }
//
//    
//    }
//    





package com.emart.controller;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.emart.entities.Customer;
import com.emart.exception.CustomerNotFoundException;
import com.emart.services.CustomerManager;

/**
 * The CustomerController class handles the API endpoints related to Customer operations.
 */
@RestController
@CrossOrigin(origins = {"http://localhost:3000", "https://react-app3-route-omkar-07-dev.apps.sandbox-m4.g2pi.p1.openshiftapps.com" , "https://react-app3-route-omkar-07-dev.apps.sandbox-m4.g2pi.p1.openshiftapps.com"})
public class CustomerController {

    @Autowired
    CustomerManager manager;

    @Autowired
    private JavaMailSender mailSender;

    public static int randomNumber;
    
    /**
     * Retrieves all the customers.
     *
     * @return ResponseEntity with the list of Customer objects if they exist,
     *         or a no content response if no customers are found.
     */
    @GetMapping(value = "api/customers/")
    public ResponseEntity<List<Customer>> showCustomers() {
        List<Customer> customers = manager.getCustomers();
        if (customers.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(customers);
        }
    }
    
    @GetMapping(value = "api/getbyemail/{email_id}")
    public List<Customer> getCustomerByEmail(@PathVariable String email_id) {
		System.out.println("inside cust by email");
    	System.out.println(manager.getCustomerbyEmail(email_id));
    	return manager.getCustomerbyEmail(email_id); 
    }
    
    /**
     * Retrieves a specific customer by their ID.
     *
     * @param customer_Id The ID of the customer to retrieve.
     * @return ResponseEntity with the Customer if found,
     *         or throws CustomerNotFoundException if the customer is not found.
     */
    @GetMapping(value = "api/customerById/{customer_Id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable int customer_Id) {
        try {
            Optional<Customer> customer = manager.getCustomer(customer_Id);
            return customer.map(ResponseEntity::ok).orElseThrow(() ->
                    new CustomerNotFoundException("Customer not found with ID: " + customer_Id));
        } catch (CustomerNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    /**
     * Removes a customer by their ID.
     *
     * @param customer_Id The ID of the customer to remove.
     * @return ResponseEntity with a success message if the customer is deleted successfully,
     *         or an error message if the customer deletion fails.
     */
    @DeleteMapping(value = "api/customer/{customer_Id}")
    public ResponseEntity<String> removeCustomer(@PathVariable int customer_Id) {
        try {
            manager.delete(customer_Id);
            return ResponseEntity.ok("Customer deleted successfully.");
        } catch (CustomerNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Customer not found with ID: " + customer_Id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to delete customer: " + e.getMessage());
        }
    }

    /**
     * Updates a customer's wallet balance by their ID.
     *
     * @param customer     The updated Customer object.
     * @param customer_Id  The ID of the customer to update.
     * @return ResponseEntity with a success message if the customer is updated successfully,
     *         or an error message if the customer update fails.
     */
    @PutMapping(value = "api/customer/{customer_Id}")
    public ResponseEntity<String> updateCustomer(@RequestBody Customer customer, @PathVariable int customer_Id) {
        try {
            manager.updateWallet(customer_Id, customer.getwallet());
            return ResponseEntity.ok("Customer updated successfully.");
        } catch (CustomerNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Customer not found with ID: " + customer_Id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to update customer: " + e.getMessage());
        }
    }

    /**
     * Adds a new customer.
     *
     * @param customer The Customer object to add.
     * @return ResponseEntity with a success message if the customer is added successfully,
     *         or an error message if the customer addition fails.
     */
    @PostMapping(value = "api/customer/{email}")
    public ResponseEntity<String> addCustomer(@PathVariable String email) {
        System.out.println("inside add customer");
       System.out.println(email);
        try {
            boolean shouldSendEmail = true; // Add your condition here to determine when to send the email
             randomNumber = generateRandomNumber();
            
            if (shouldSendEmail) {
                ResponseEntity<String> emailResponse = sendEmail(email);
                if (emailResponse.getStatusCodeValue() == 200) {
                System.out.println(randomNumber);

                    System.out.println("Email send successfully"+randomNumber);
                    return ResponseEntity.ok("Email send successfully."+randomNumber);
                } else {
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send email.");
                }
            } else {
//                manager.addCustomer(customer);
//                System.out.println("added successfully");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send email.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to add customer: " + e.getMessage());
        }
    }
    
    /**
     * Sends an email with the OTP to the specified email address.
     *
     * @param email The email address to send the OTP to.
     * @return ResponseEntity with a success message if the email is sent successfully,
     *         or an error message if the email sending fails.
     */
    @PostMapping(value = "api/send-email")
    public ResponseEntity<String> sendEmail(String email) {
    	System.out.println("email");
    	System.out.println(email);
        try {
            boolean shouldSendEmail = true; // Add your condition here to determine when to send the email
             randomNumber = generateRandomNumber();
            
            if (shouldSendEmail) {
                SimpleMailMessage message = new SimpleMailMessage();
                message.setTo(email);
                message.setSubject("onestop Email");
                message.setText("This is a registration email sent from Spring Boot.");
                message.setText("OTP is - " + randomNumber);
                mailSender.send(message);
                System.out.println("send successfully");
                return ResponseEntity.ok("Email sent successfully.");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Failed to send email: ");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to send email: " + e.getMessage());
        }
    }
    
    /**
     * Validates the provided OTP.
     *
     * @param randomNumber2 The OTP to validate.
     * @return ResponseEntity with a boolean indicating if the OTP is valid or not.
     */
    @PostMapping("api/addcustme")
    public ResponseEntity<String> validateOtp(@RequestBody Customer customer) {
    
    	System.out.println(randomNumber);
     System.out.println(customer);
    	
        if (customer!=null) {
        	manager.addCustomer(customer);
            return ResponseEntity.ok("Customer added successfully"); 
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failded to add customer");
        } 
        }

    
    /**
     * Generates a random 4-digit number.
     *
     * @return The generated random number.
     */
    public static int generateRandomNumber() {
        Random random = new Random();
        int min = 1000; // Minimum 4-digit number
        int max = 9999; // Maximum 4-digit number
        return random.nextInt(max - min + 1) + min;
    }
}
