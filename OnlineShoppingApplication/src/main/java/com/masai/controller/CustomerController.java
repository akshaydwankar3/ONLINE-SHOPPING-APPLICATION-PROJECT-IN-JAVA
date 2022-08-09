package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entity.Customer;
import com.masai.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService cService;
	
	@PostMapping("/customers")
	public ResponseEntity<Customer> addCustomerHandler(@RequestBody Customer customer){
		
		Customer savedCustomer = cService.addCustomer(customer);
		
		return new ResponseEntity<Customer>(savedCustomer,HttpStatus.CREATED);
	}
	
	@GetMapping("/customers/{customerId}")
	public Customer getCustomerById(@PathVariable("customerId") Integer customerId) {
		return cService.viewCustomer(customerId);
	}
	
	
	
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomerDetails(){
		
		List<Customer> customers = cService.viewAllCustomers();
		
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}
	
	@DeleteMapping("/customers/{customerId}")
	public Customer deleteCustomerById(@PathVariable("customerId") Integer customerId) {
		return cService.removeCustomer(customerId);
	}
	
	@PutMapping("/customers")
	public ResponseEntity<Customer> updateStudentHandler(@RequestBody Customer customer){
		
		Customer updatedCustomer = cService.updateCustomer(customer);
		
		return new ResponseEntity<Customer>(updatedCustomer, HttpStatus.ACCEPTED);
	}
	
	

}
