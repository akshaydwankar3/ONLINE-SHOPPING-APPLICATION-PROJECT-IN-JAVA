package com.masai.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entity.Bank;
import com.masai.entity.Product;

@RestController
public class BankController {
	
	
	@PostMapping("/addbankdetails")
	public String savebankdetails(Bank bank) {
		return "Bank details added succesfully...!"+bank.toString();
	}
	
	@GetMapping("/getbankbalance")
	public String getbankBalance(Bank bank) {
		return "Amount in your Account "+bank.getBank_Balance();
	}
	
	@GetMapping("/productprice/bankbalanceafterdetection")
	public String detectbankbalanceafterplacingorder(Bank bank) {
		Product p = new Product();
		double balance = bank.getBank_Balance();
		double pprice = p.getPrice();
		double bankbalance = balance-pprice;
		if(balance < pprice) return "Insufficient funds...!";
		else return "Amount detected from your Bank...! Your Bank balance:"+bankbalance;
	}
	
	
	
	
	
	
	
	
}
