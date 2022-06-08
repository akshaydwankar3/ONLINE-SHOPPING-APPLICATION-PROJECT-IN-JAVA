package com.masai.service;

import com.masai.entity.Bank;

public interface BankService {
	
	public String savebankdetails(Bank bank);
	public String getBankBalance(Bank bank);
}
