package com.masai.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.masai.entity.Bank;

public interface BankService {
	
	public Bank saveBank(Bank bank);
	
	public List<Bank>getAllBanks();
	
	
}
