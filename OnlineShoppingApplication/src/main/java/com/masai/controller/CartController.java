package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entity.Address;
import com.masai.entity.Cart;
import com.masai.entity.Product;
import com.masai.service.CartService;
import com.masai.service.ProductService;


@RestController
public class CartController {
	
	@Autowired
	private CartService cService;
	
	@Autowired
	private ProductService pService;
	
	
//	@PostMapping("/saveAddress")
//	public ResponseEntity<Address> saveAddressHandler(@RequestBody Address address) {
////		Address address = new Address(id, city, state, pincode);
//		Address savedAddress = aService.saveAddress(address);
//		return new ResponseEntity<Address>(savedAddress,HttpStatus.CREATED);
//	}
	@PostMapping("/saveincart/{id}")
	public Cart saveProductHandler(@PathVariable("id") Integer id) {
		Product P = pService.getProductById(id);
		System.out.println(P.getProductId());
		Cart savedProduct = cService.saveProduct(id);
		return null;
		
//		return savedProduct;
//		return new ResponseEntity<Cart>(savedProduct,HttpStatus.CREATED);
	}
	
	@GetMapping("/getproduct/{id}")
	public Product getProductbyIdHandler(@PathVariable("id") int id) {
		return cService.getProductbyId(id);
	}
	
	@PostMapping("/deleteproduct/{id}")
	public Product deleteProductbyIdHandler(@PathVariable("id") int id) {
		return cService.deleteProductbyId(id);
	}
	
	@GetMapping("/findall")
	public List<Product> all(){
		return cService.allProduct();
	}
	
	@GetMapping("/total")
	public double total() {
		return cService.getTotal();
	}
}