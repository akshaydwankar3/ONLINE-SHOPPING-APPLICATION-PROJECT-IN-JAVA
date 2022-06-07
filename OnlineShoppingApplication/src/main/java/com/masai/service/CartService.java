package com.masai.service;

import java.util.List;
import com.masai.entity.Cart;
import com.masai.entity.Product;

public interface CartService {
	
	public Cart saveProduct(Integer id);
	
	public Product getProductbyId(Integer id);
	
	public Product deleteProductbyId(Integer id);
	
	public Double getTotal();
	
	public List<Product> allProduct();
}
