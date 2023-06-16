package com.emart.controller;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emart.entities.Admin;
import com.emart.entities.AdminLogin;
import com.emart.entities.Category;
import com.emart.entities.Product;
import com.emart.entities.ProductDetails;
import com.emart.exception.AdminNotFoundException;
import com.emart.services.AdminService;
import com.emart.services.CategoryManagerImpl;
import com.emart.services.ProductDetailsManagerImpl;
import com.emart.services.ProductManager;

/**
 * The AdminController class handles the API endpoints related to admin operations.
 */
@RestController
@CrossOrigin(origins = {"http://localhost:3000", "https://react-app3-route-omkar-07-dev.apps.sandbox-m3.1530.p1.openshiftapps.com","https://react-app3-route-omkar-07-dev.apps.sandbox-m4.g2pi.p1.openshiftapps.com"})
@RequestMapping("/admins")
public class AdminController {

    private final AdminService adminService;
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping(value = "/showadmins")
	public List<Admin> getAll(){
		return adminService.getAll();
	}
    /**
     * Get an admin by ID.
     *
     * @param id The ID of the admin to retrieve.
     * @return ResponseEntity with the Admin object if it exists,
     *         or a not found response if the admin is not found.
     */
    @GetMapping("/showadmins/{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable int id) {
        try {
            Admin admin = adminService.getAdminById(id);
            return ResponseEntity.ok(admin);
        } catch (AdminNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    /**
     * Create a new admin.
     *
     * @param admin The Admin object containing the details of the new admin.
     * @return ResponseEntity with the created Admin object if successful,
     *         or an internal server error response if the creation fails.
     */
    @PostMapping("/showadmins")
    public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {
        try {
            Admin createdAdmin = adminService.createAdmin(admin);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdAdmin);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    /**
     * Update an existing admin.
     *
     * @param id    The ID of the admin to update.
     * @param admin The updated Admin object.
     * @return ResponseEntity with the updated Admin object if successful,
     *         or a not found response if the admin is not found.
     */
    @PutMapping("/showadmins/{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable int id, @RequestBody Admin admin) {
        try {
            Admin updatedAdmin = adminService.updateAdmin(id, admin);
            return ResponseEntity.ok(updatedAdmin);
        } catch (AdminNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    /**
     * Delete an admin by ID.
     *
     * @param id The ID of the admin to delete.
     * @return ResponseEntity with a success message if the admin is deleted successfully,
     *         or a not found response if the admin is not found.
     */
    @DeleteMapping("/showadmins/{id}")
    public ResponseEntity<String> deleteAdmin(@PathVariable int id) {
        try {
            String result = adminService.deleteAdmin(id);
            return ResponseEntity.ok(result);
        } catch (AdminNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

   

 // Admin registration
    @PostMapping("/adminRegister")
    public void adminRegister(@RequestBody Admin admin) {
        adminService.add(admin);
    }

    // Checking BCrypt password
    // Parameters:
    // - plainPassword: The plain text password to be checked.
    // - hashedPassword: The hashed password to compare against.
    static private boolean checkPass(String plainPassword, String hashedPassword) {
        if (BCrypt.checkpw(plainPassword, hashedPassword)) {
            System.out.println("The password matches.");
            return true;
        } else {
            System.out.println("The password does not match.");
            return false;
        }
    }

    // Admin table check for logged-in email and password
    // Parameters:
    // - email: The email of the admin to check.
    // - plainPassword: The plain text password to be checked.
    public Admin adminCheck(String email, String plainPassword) {
        Admin admin = adminService.getByEmail(email);
        if (admin != null) {
            String hashedPassword = admin.getPassword();
            if (checkPass(plainPassword, hashedPassword)) {
                return admin;
            }
        }
        return null;
    }

    // Admin login
    // Parameters:
    // - admin: The Admin object containing the email and password for login.
    public Object adminLogin(@RequestBody Admin admin) {
        String email = admin.getEmailId();
        String plainPassword = admin.getPassword();
        if (adminCheck(email, plainPassword) != null) {
            return adminCheck(email, plainPassword);
        } else {
            return null;
        }
    }

    // Check if email exists
    // Parameters:
    // - admin: The Admin object containing the email to check.
    public boolean checkEmail(@RequestBody Admin admin) {
        String email = admin.getEmailId();
        if (adminService.getByEmail(email) != null) {
            return true;
        }
        return false;
    }
    

	@Autowired
	CategoryManagerImpl categorymanager;
	
	
	
	/*
	 * category manipulation
	 */
	
	 @GetMapping(value = "/showcategories")
		public List<Category> getCategories(){
			return categorymanager.getAllCategories();
		}
//		 @GetMapping(value = "api/Hello")
//		public String Hello(){
//			return "Hello";
//		}
		 @GetMapping(value = "/showcategories/{cid}")
		 public Optional<Category> getCategory(@PathVariable int cid)
		 {
			Optional<Category> p=categorymanager.getCategory(cid);
			return p;
		 }
		 @DeleteMapping(value = "/showcategories/{cid}")
		 public void removeCategory(@PathVariable int cid)
		 {
			 categorymanager.delete(cid);
		 }
		 @PutMapping(value = "/showcategories/{cid}")
		 public void updateCategory(@RequestBody Category category,@PathVariable int cid)
		 {
			//System.out.println("inside updatecategory of controller");
			categorymanager.update(category,cid);
		 }
		 @PostMapping(value = "/showcategories")
		public void addCategory(@RequestBody Category category){
			//System.out.println("add category called");
			categorymanager.addCategory(category);
		}
		 
		 @Autowired
			ProductManager manager;
			
			
			 @GetMapping(value = "showproducts")
			 public List<Product> showProducts1()
			 {
				  return manager.getProducts(); 
				
			 }
			 @PutMapping(value = "/showproducts/{pid}")
			 public void updateProduct(@RequestBody Product product,@PathVariable int pid)
			 {
				//System.out.println("inside updatecategory of controller");
				manager.update(product,pid);
			 }
			 @GetMapping(value = "showproducts/{pid}")
			 public Optional<Product> getPro(@PathVariable int pid)
			 {
				Optional<Product> p=manager.getProduct(pid);
				return p;
			 }
			 
			 
			 @DeleteMapping(value = "showproducts/{pid}")
			 public void removepro(@PathVariable int pid)
			 {
				manager.delete(pid);
			 }
			
			 @PostMapping(value = "showproducts")
			 public void addpro(@RequestBody Product product)
			 {
				System.out.println("addpro called");
				manager.addProduct(product);
			 }
			 
			 @Autowired
				ProductDetailsManagerImpl productdetailmanager;
				
				
				@GetMapping(value = "showproductdetails")
				 public List<ProductDetails> showProductDetails()
				 {
					  return productdetailmanager.getProductDetails();
					
				}
				
				@GetMapping(value = "showproductdetails/{productDetail_Id}")
				 public Optional<ProductDetails> getProductDetail(@PathVariable int productDetail_Id)
				 {
					Optional<ProductDetails> p=productdetailmanager.getProductDetail(productDetail_Id);
					return p;
				 }


				 @DeleteMapping(value = "showproductdetails/{cid}")
				 public void delete(@PathVariable int cid)
				 {
					productdetailmanager.delete(cid);
				 }

				 @PostMapping(value = "showproductdetails")
				 public void getProductDetails(@RequestBody ProductDetails prod)
				 {
					System.out.println("addproductDetails called");
					productdetailmanager.addProductDetails(prod);
				 }
				 
				 @PutMapping(value = "/showproductdetails/{pid}")
				 public void updateProductDetails(@RequestBody ProductDetails product,@PathVariable int pid)
				 {
					//System.out.println("inside updatecategory of controller");
					 productdetailmanager.update(product,pid);
				 }
		 
		
				 @PostMapping("/login")
				    public ResponseEntity<String> login(@RequestBody AdminLogin loginForm) {
				        String email = loginForm.getemailId();
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
				       
				    	List<Admin> ls = adminService.getAll();
//				    	String pass=passwordEncoder.encode(password);\
				    	
				    	System.out.println("Password after encode");
				    	
				    	for (Admin admin : ls) {
				    		System.out.println(admin.getEmailId());
				    		System.out.println(admin.getPassword());
							if((email.equals(admin.getEmailId())) && bCryptPasswordEncoder.matches(password, admin.getPassword())) {
								System.out.println("Mached");
								return true;
							}	
						}
				    	return false;
				}

}
