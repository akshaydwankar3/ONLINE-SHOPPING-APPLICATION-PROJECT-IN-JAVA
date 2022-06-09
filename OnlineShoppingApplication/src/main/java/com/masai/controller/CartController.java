package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@PostMapping("/carts")
	public Cart saveProductHandler(@RequestBody Cart product) {
		Cart savedProduct = cService.saveProduct(product);
		return savedProduct;
	}
	
	@GetMapping("/carts/{id}")
	public Product getProductbyIdHandler(@PathVariable("id") Integer id) {
		return cService.getProductbyId(id);
	}
	
	@PutMapping("/addproduct/{id}")
	public Cart addProduct(@PathVariable("id") Integer id, @RequestBody List<Product> productlist) {
		
		return cService.addProductTocart(id, productlist);
	}
	
	@PostMapping("/deleteproduct/{id}")
	public Product deleteProductbyIdHandler(@PathVariable("id") Integer id) {
		return cService.deleteProductbyId(id);
	}
	
	@GetMapping("/findall/{id}")
	public List<Product> all(@PathVariable("id") Integer id){
		return cService.allProduct(id);
	}
	
	@GetMapping("/total/{id}")
	public double total(@PathVariable("id") Integer id) {
		return cService.getTotal(id);
	}
}
