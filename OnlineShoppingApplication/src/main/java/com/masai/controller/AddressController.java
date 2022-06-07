package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entity.Address;
import com.masai.service.AddressService;

@RestController
public class AddressController{
	
	@Autowired
	private AddressService aService;

	@PostMapping("/saveAddress/{city}/{state}/{pincode}")
	public ResponseEntity<Address> saveAddressHandler(@PathVariable("city") String city,@PathVariable("state") String state,@PathVariable("pincode") String pincode) {
		Address address = new Address(city, state, pincode);
		Address savedAddress = aService.saveAddress(address);
		return new ResponseEntity<Address>(savedAddress,HttpStatus.CREATED);
	}
	
	@PostMapping("/saveAddress")
	public ResponseEntity<Address> saveAddressHandler(@RequestBody Address address) {
//		Address address = new Address(id, city, state, pincode);
		Address savedAddress = aService.saveAddress(address);
		return new ResponseEntity<Address>(savedAddress,HttpStatus.CREATED);
	}
	
	@GetMapping("/getAddress/{id}")
	public Address getAddressbyIdHandler(@PathVariable("id") int id) {
		return aService.getAddressbyId(id);
	}
	
	@PostMapping("/deleteAddress/{id}")
	public Address andler(@PathVariable("id") int id) {
		return aService.deleteAddressbyId(id);
	}
	
	@PostMapping("/updateAddress")
	public ResponseEntity<Address> updateAddress(@RequestBody Address address){
		Address updatedAddress = aService.updateAddress(address);
		return new ResponseEntity<Address>(updatedAddress,HttpStatus.ACCEPTED);
	}
	

}
