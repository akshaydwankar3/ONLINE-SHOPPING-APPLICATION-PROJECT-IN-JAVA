package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entity.Address;
import com.masai.exception.AddressExp;
import com.masai.reopsitory.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService{

	@Autowired
	private AddressRepository AR;
	
	@Override
	public Address saveAddress(Address add) {
		return AR.save(add);
	}

	@Override
	public Address getAddressbyId(Integer id) throws AddressExp{
		Optional<Address> opt = AR.findById(id);
		if(opt.isPresent()) {
			Address add = opt.get();
			return add;
		}
		else
			throw new AddressExp("no Address found by id"+id);
	}
	
	@Override
	public Address deleteAddressbyId(Integer id) {
		Address add = AR.findById(id).orElseThrow(()-> new AddressExp("Address does not exist"));
		AR.delete(add);
		return add;
	}
	
	@Override
	public Address updateAddress(Address address) throws AddressExp{
		
		Optional<Address> add = AR.findById(address.getId());
		if(add.isPresent()) {
//			Address exStudent = add.get();
			return AR.save(address);
		}
		else
			throw new AddressExp("invalid Student Details");
	}
}
