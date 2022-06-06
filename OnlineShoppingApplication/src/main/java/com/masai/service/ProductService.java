package com.masai.service;

import java.util.List;

import com.masai.entity.Product;
import com.masai.exception.ProductNotFoundException;


public interface ProductService {

	public Product saveProduct(Product product);
	
	public Product getProductById(Integer id)throws ProductNotFoundException;
	
	public List<Product> getAllProducts() throws ProductNotFoundException;
	
	public Product deleteProductById(Integer id)throws ProductNotFoundException;
	
	public Product updateProduct(Product product) throws ProductNotFoundException;
	
	public Product updateProductPrice(Integer id, Double addPrice)throws ProductNotFoundException;
	
    public List<Product> getProductDetailsByName(String name) throws ProductNotFoundException;
	
	public List<Product> getProductDetailsByNameOrPrice(String name, Double price) throws ProductNotFoundException;
	
	public List<Product> getProductDetailsByNameAndPrice(String name, Double price) throws ProductNotFoundException;
	
}
