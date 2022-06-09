package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entity.Address;
import com.masai.exception.AddressException;
import com.masai.repository.AddressDao;
import com.masai.repository.CustomerDao;

@Service
public class AddressServiceImpl implements AddressService{

	@Autowired
	private AddressDao aDao;
	
	@Override
	public Address saveAddressDetails(Address add) {
		return aDao.save(add);
	}

	@Override
	public List<Address> getAddress() throws AddressException {
		List<Address> address=aDao.findAll();
		if(address.size()>0) {
			return address;
		}
		else {
			throw new AddressException("No Address found...");
		}
	}
	
	@Override
	public Address getAddressbyId(Integer id) {
		Optional<Address> opt = aDao.findById(id);
		if(opt.isPresent()) {
			Address add = opt.get();
			return add;
		}
		else
			throw new AddressException("no Address found by id"+id);
	}
	
	@Override
	public Address deleteAddressbyId(Integer id) {
		Address add = aDao.findById(id).orElseThrow(()-> new AddressException("Address does not exist"));
		aDao.delete(add);
		return add;
	}
	
	@Override
	public Address updateAddress(Address address){
		
		Optional<Address> add = aDao.findById(address.getId());
		if(add.isPresent()) {
			Address exStudent = add.get();
			return aDao.save(address);
		}
		else
			throw new AddressException("invalid Address Details");
	}

	
}