package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CustomerException;
import com.masai.entity.Customer;
import com.masai.repository.CustomerDao;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerDao cDao;

	@Override
	public Customer addCustomer(Customer customer) {
		
		return cDao.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {

		Optional<Customer> opt = cDao.findById(customer.getCustomerId());
		
		if(opt.isPresent()) {
			
			Customer existingCustomer = opt.get();
			
			return cDao.save(customer);
		}
		else {
			throw new CustomerException("Invalid Customer Details...");
		}
	}

	@Override
	public Customer removeCustomer(Integer customerId) {

		Customer existingCustomer =  cDao.findById(customerId).orElseThrow(()-> new CustomerException("Customer does not exist with Roll "+customerId));
		
		cDao.delete(existingCustomer);
		
		return existingCustomer;
	}

	@Override
	public Customer viewCustomer(Integer customerId)  {
		
		
		return cDao.findById(customerId).orElseThrow(()-> new CustomerException("Customer does not exist with Roll "+customerId));
	}

	@Override
	public List<Customer> viewAllCustomers() throws CustomerException {

		List<Customer> students = cDao.findAll();
		
		if(students.size() > 0)
			return students;
		else
			throw new CustomerException("No Customer found...");
		}
	
	
	}
