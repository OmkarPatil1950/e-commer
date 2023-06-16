package com.emart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.emart.services.BillService;
@CrossOrigin(origins = {"http://localhost:3000", "https://react-app3-route-omkar-07-dev.apps.sandbox-m3.1530.p1.openshiftapps.com","https://react-app3-route-omkar-07-dev.apps.sandbox-m4.g2pi.p1.openshiftapps.com"})
@RestController
public class BillingController {

	@Autowired
	private BillService billservice;
	
	
	@GetMapping(value = "bill/{email_id}")
	public ResponseEntity <List<Object[]>>getBill(@PathVariable String email_id){
		System.out.println("inside email bill");
		
		 List<Object[]> bill = billservice.BillDetails(email_id);
		for (Object[] objects : bill) {
			System.out.println(objects);
		}
		 return ResponseEntity.ok(bill);
	}
}
