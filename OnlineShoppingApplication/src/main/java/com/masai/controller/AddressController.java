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

import com.masai.entity.Address;
import com.masai.exception.AddressException;
import com.masai.service.AddressService;

@RestController
public class AddressController{
	
	@Autowired
	private AddressService aService;

//	@PostMapping("/saveAddres/{city}/{state}/{pincode}")
//	public ResponseEntity<Address> saveAddressHandler(@PathVariable("city") String city,@PathVariable("state") String state,@PathVariable("pincode") String pincode) {
//		Address address = new Address(city, state, pincode);
//		Address savedAddress = aService.saveAddressDetails(address);
//		return new ResponseEntity<Address>(savedAddress,HttpStatus.CREATED);
//	}
	
	@PostMapping("/saveAddress")
	public ResponseEntity<Address> saveAddressHandler(@RequestBody Address address) {
    	
		Address savedAddress = aService.saveAddressDetails(address);
		return new ResponseEntity<Address>(savedAddress,HttpStatus.CREATED);
	}
	
	@GetMapping("/address/{id}")
	public Address getAddressbyIdHandler(@PathVariable("id") Integer id) {
		return aService.getAddressbyId(id);
	}
	
	@GetMapping("/address")
	public ResponseEntity<List<Address>> getAllAddress(){
		List<Address> addresslist=aService.getAddress();
		
			return new ResponseEntity<List<Address>>(addresslist,HttpStatus.OK);
		
		
	}
	
	@DeleteMapping("/address/{id}")
	public Address andler(@PathVariable("id") Integer id) {
		//Address adr= aService.getAddressbyId(id);
		return aService.deleteAddressbyId(id);
		//return adr;
	}
	
	@PutMapping("/address")
	public ResponseEntity<Address> updateAddress(@RequestBody Address address){
		Address updatedAddress = aService.updateAddress(address);
		return new ResponseEntity<Address>(updatedAddress,HttpStatus.ACCEPTED);
	}
	

}

