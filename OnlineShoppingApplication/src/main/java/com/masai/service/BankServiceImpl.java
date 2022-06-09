package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.masai.entity.Bank;
import com.masai.repository.BankDao;

@Service
public class BankServiceImpl implements BankService{
	
	@Autowired
	public BankDao bDao;

	@Override
	public Bank saveBank(Bank bank) {
		return bDao.save(bank);
	}

	@Override
	public List<Bank> getAllBanks() {
		List<Bank> banks = bDao.findAll();
		return banks;
	}

	
	
	
}
