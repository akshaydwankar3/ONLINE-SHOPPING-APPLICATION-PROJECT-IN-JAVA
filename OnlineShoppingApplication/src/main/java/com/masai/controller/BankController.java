package com.masai.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entity.Bank;
import com.masai.entity.Product;
import com.masai.reopsitory.BankDao;
import com.masai.service.BankService;

@RestController
public class BankController{
	
	@Autowired
	private BankService bService;
	
	@Autowired
	private BankDao bDao;
	
	@PostMapping("/addbank")
	public ResponseEntity<Bank>saveBankHandler(@RequestBody Bank bank){
		Bank savedBank = bService.saveBank(bank);
		return new ResponseEntity<Bank>(savedBank, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/banks")
	public ResponseEntity<List<Bank>>getAllBanksI(){
		List<Bank> banks = bService.getAllBanks();
		return new ResponseEntity<List<Bank>>(banks, HttpStatus.OK);
	}
	
}
