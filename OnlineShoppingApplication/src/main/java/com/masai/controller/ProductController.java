package com.masai.controller;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.dto.ProductDTO;
import com.masai.entity.Product;
import com.masai.exception.ProductNotFoundException;
import com.masai.repository.ProductDao;
import com.masai.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService pService;
	
	@Autowired
	private ProductDao pDao;
	
	
	
	@PostMapping("/products")
	public ResponseEntity<Product> saveProductHandler(@RequestBody Product product){
		Product savedProduct= pService.saveProduct(product);
		
		return new ResponseEntity<Product>(savedProduct, HttpStatus.CREATED);
	}
	
	@GetMapping("/products/{id}")
	public Product getProductById(@PathVariable("id") Integer id) {
		return pService.getProductById(id);
	}
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts(){
		List<Product> products=pService.getAllProducts();
		
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
	
	@DeleteMapping("/products/{id}")
	public Product deleteProductById(@PathVariable("id") Integer id) {
		return pService.deleteProductById(id);
	}
	
	@PutMapping("/products")
	public ResponseEntity<Product> updateProductHandler(@RequestBody Product product){
		
		Product updatedProduct=pService.updateProduct(product);
		
		return new ResponseEntity<Product>(updatedProduct, HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/products/{productId}")
	public ResponseEntity<Product> updatedProductPrice(@PathVariable("productId") Integer id, @RequestParam("price") Double price ){
		Product updateProduct= pService.updateProductPrice(id, price);
		return new ResponseEntity<Product>(updateProduct, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/pNameAndPrice/{productName}")
	public List<ProductDTO> ProductDTOHandler(@PathVariable("productName") String name){
		List<ProductDTO> pResult= pDao.getProductNameAndMarksById(name);
		
		if(pResult.size()>0) {
			return pResult;
		}
		else {
			throw new ProductNotFoundException("Product not found with name :"+name);
		}
	}
	
	public List<Product> getProductByName(@PathVariable("productName") String name){
		
		return pService.getProductDetailsByName(name);
		
	}
	
	
@GetMapping("/getbynameOrprice/{productName}/{price}")	
public List<Product> getProductByNameOrPrice(@PathVariable("productName") String name, @PathVariable("price") Double price){
	List<Product> products= pService.getProductDetailsByNameOrPrice(name, price);
	return products;
}

@GetMapping("/getbynameAndprice/{productName}/{price}")
public List<Product> getProductByNameAndPrice(@PathVariable("productName") String name, @PathVariable("price") Double price){
	List<Product> products= pService.getProductDetailsByNameAndPrice(name, price);
	return products;
}

@GetMapping("/getname/{productId}")
public String getNameById(@PathVariable("productId") Integer id) {
	String name= pDao.getProductsNameById(id);
	if(name!=null) {
		return name;
	}
	else {
		throw new ProductNotFoundException("Product not found");
	}
}

@GetMapping("/pnamebyprice/{price}")
public List<String> getProductNameByPrice(@PathVariable("price") Double price){
	
	List<String> pName= pDao.getProductnameByPrice(price);
	if(pName.size()>0) {
		return pName;
	}
	else {
		throw new ProductNotFoundException("Product is not found int the list by price :"+price);
	}
}
	
}
