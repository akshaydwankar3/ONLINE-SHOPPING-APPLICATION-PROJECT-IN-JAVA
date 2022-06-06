package com.masai.addressC;

import com.masai.model.Address;

public interface AddressService {
	
	public Address saveAddress(Address address);
	
	public Address getAddressbyId(Integer id);
	
	public Address deleteAddressbyId(Integer id);
	
	public Address updateAddress(Address address);

}
