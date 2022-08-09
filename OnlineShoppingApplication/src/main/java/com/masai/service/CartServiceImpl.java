package com.masai.service;

import java.lang.StackWalker.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entity.Cart;
import com.masai.entity.Product;
import com.masai.exception.CartException;
import com.masai.exception.ProductNotFoundException;
import com.masai.repository.CartDao;
import com.masai.repository.ProductDao;

@Service
public class CartServiceImpl implements CartService{
	

	
	@Autowired
	private CartDao CR;
	
	@Autowired
	private ProductService pr;

	@Autowired
	private ProductDao pDao;
	
	@Override
	public Cart saveProduct(Cart product) {
		
			return CR.save(product);
		
	}

	@Override
	public Product getProductbyId(Integer id) {
		Product product = CR.getproductByProductId(id);
	
		if(product!=null) {
			return product;	
	   }
	else {
		throw new ProductNotFoundException("Product dose not exist... ");
	}
		
		
   }
	
	
	
	@Override
	public Product deleteProductbyId(Integer id) {
		Integer cartId= CR.getIdByPid(id);
		Cart cart=CR.getById(cartId);
		if(cart!=null) {
			List<Product> products=cart.getProducts();
			Product p=CR.getproductByProductId(id);
			products.remove(p);
			return p;
		}
		else {
			throw new CartException("Cart dose not exist ..");
		}
		
		
		
	}


	@Override
	public Double getTotal(Integer id) {
		Double total = 0.0;
		Cart cart=CR.getById(id);
		if(cart!=null) {
			List<Product> pr = cart.getProducts();
			for(Product p:pr) {
				Integer c=p.getQuantity();
				total+=(p.getPrice())*c;
			}
			return total;
		}
		else {
			throw new CartException("Product dose not exist...");
		}
				
	}

	@Override
	public List<Product> allProduct(Integer id) {
		@SuppressWarnings("deprecation")
		Cart cart=CR.getById(id);
		if(cart!=null) {
			List<Product> p = cart.getProducts();
			return p;
		}
		else {
			throw new CartException("Cart dose not exist with id :"+id);
		}
		
	}

	@Override
	public List< Cart> getCartDetails() throws CartException {
		List<Cart> cart= CR.findAll();
		if(cart.size()>0) {
			return cart;
		}
		else {
			throw new CartException("Cart is empty..");
		}
	}

	@Override
	public Cart addProductTocart(Integer id,List<Product> product) throws CartException {
	
		Optional<Cart> cart= CR.findById(id);
		if(cart.isPresent()) {
			Cart carts=cart.get();
			List<Product> prod=carts.getProducts();
			prod.addAll(product);
				carts.setProducts(prod);
				CR.save(carts);
			 return carts;
		}
		else {
			throw new CartException("Cart dose not exist ...");
		}
	}

	@Override
	public Cart getCartById(Integer id) throws CartException {
		Optional<Cart> cart=CR.findById(id);
		if(cart.isPresent()) {
			return cart.get();
		}
		else {
			throw new CartException("Cart dose not exist with id: "+id);
		}
	}

	@Override
	public Cart deleteCartById(Integer id) throws CartException {
		Optional<Cart> cart=CR.findById(id);
		if(cart.isPresent()) {
			CR.delete(cart.get());
			return cart.get();
		}
		else {
			throw new CartException("Cart dose not exist with id :"+id);
		}
	}

	

}
