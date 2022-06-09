package com.masai.service;

import java.util.List;

import com.masai.exception.CustomerException;
import com.masai.entity.Customer;

public interface CustomerService {
	

	public Customer addCustomer(Customer customer);
	
	public Customer updateCustomer(Customer customer)throws CustomerException;
	
	public Customer removeCustomer(Integer customerId)throws CustomerException;
	
	public Customer viewCustomer(Integer customerId)throws CustomerException;
	
	public List<Customer> viewAllCustomers()throws CustomerException;

}