package com.masai.addressC;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.Address;
import com.masai.reopsitory.CustomerRepository;

import masai.com.Exeptions.AddressExp;

@Service
public class AddressServiceImpl implements AddressService{

	@Autowired
	private CustomerRepository CR;
	
	@Override
	public Address saveAddress(Address add) {
		return CR.save(add);
	}

	@Override
	public Address getAddressbyId(Integer id) throws AddressExp{
		Optional<Address> opt = CR.findById(id);
		if(opt.isPresent()) {
			Address add = opt.get();
			return add;
		}
		else
			throw new AddressExp("no Address found by id"+id);
	}
	
	@Override
	public Address deleteAddressbyId(Integer id) {
		Address add = CR.findById(id).orElseThrow(()-> new AddressExp("Address does not exist"));
		CR.delete(add);
		return add;
	}
	
	@Override
	public Address updateAddress(Address address) throws AddressExp{
		
		Optional<Address> add = CR.findById(address.getId());
		if(add.isPresent()) {
			Address exStudent = add.get();
			return CR.save(address);
		}
		else
			throw new AddressExp("invalid Student Details");
	}
}
