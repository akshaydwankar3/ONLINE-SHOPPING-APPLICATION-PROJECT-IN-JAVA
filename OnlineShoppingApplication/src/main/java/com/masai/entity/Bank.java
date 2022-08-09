package com.masai.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="BankDetails")
@ToString
public class Bank {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer BankId;
//	public Bank(String account_Number) {
//		super();
//		Account_Number = account_Number;
//	}
	private String Account_Number;
	private String IFSC_Code;
	private double Bank_Balance;
	
}

