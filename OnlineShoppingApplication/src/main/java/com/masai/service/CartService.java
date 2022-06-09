package com.masai.service;

import java.util.List;
import com.masai.entity.Cart;
import com.masai.entity.Product;
import com.masai.exception.CartException;

public interface CartService {
	
	public Cart saveProduct(Cart products);
	
	public List<Cart> getCartDetails() throws CartException;
		
	public Cart addProductTocart(Integer id ,List<Product> product) throws CartException;
	
	
	public Product getProductbyId(Integer id) throws CartException;
	
	public Product deleteProductbyId(Integer id)throws CartException;
	
	public Double getTotal(Integer id) throws CartException;
	
	public List<Product> allProduct(Integer id)throws CartException;
}
