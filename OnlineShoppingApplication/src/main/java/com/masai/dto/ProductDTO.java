package com.masai.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductDTO {

	//private Integer productId;
	private String productName;
	//private String category;
	private double price;
	
}
