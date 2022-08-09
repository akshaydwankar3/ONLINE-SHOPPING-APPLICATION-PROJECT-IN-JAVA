package com.masai.service;

import java.util.List;

import com.masai.entity.Address;
import com.masai.exception.AddressException;

public interface AddressService {
	
	public Address saveAddressDetails(Address address);
	
	public Address getAddressbyId(Integer id) throws AddressException;
	
	public List<Address> getAddress() throws AddressException;
	
	public Address deleteAddressbyId(Integer id)throws AddressException;
	
	public Address updateAddress(Address address)throws AddressException;

}
