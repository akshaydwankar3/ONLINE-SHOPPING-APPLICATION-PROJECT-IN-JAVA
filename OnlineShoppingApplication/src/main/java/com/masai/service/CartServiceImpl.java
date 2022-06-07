package com.masai.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entity.Cart;
import com.masai.entity.Product;
import com.masai.exception.AddressExp;
import com.masai.exception.CartExp;
import com.masai.reopsitory.CartRepository;
import com.masai.exception.ProductNotFoundException;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartRepository CR;
	
	@Autowired
	private ProductServiceImpl pr;

	@Override
	public Cart saveProduct(Integer id) {
		Product p = pr.getProductById(id);
		System.out.println(p);
		if(p == null)
			throw new ProductNotFoundException();
		else {
			Cart crt = new Cart(id);
			return CR.save(crt);
		}
	}

	@Override
	public Product getProductbyId(Integer id) {
		Optional<Cart> opt = CR.findById(id);
		if(opt.isPresent()) {
			Cart c = opt.get();
			System.out.println(c.getProductid());
			Product p = pr.getProductById(c.getProductid());
			return p;
	}
	else
		throw new CartExp("no item found by id"+id);
	}

	@Override
	public Product deleteProductbyId(Integer id) {
		@SuppressWarnings("deprecation")
		Cart p = CR.getById(id);
		CR.deleteById(id);
		return pr.getProductById(p.getProductid());
	}


	@Override
	public Double getTotal() {
		Double total = 0.0;
		List<Product> pr = allProduct();
		List<Double> dlist = new ArrayList<Double>();
		pr.forEach(price -> dlist.add(price.getPrice()));
		for(double p : dlist) {
			total += p;
		}
		return total;
		
	}

	@Override
	public List<Product> allProduct() {
		List<Product> p = new ArrayList<Product>();
		List<Cart> pn = CR.findAll();
		pn.forEach(Cart -> p.add(pr.getProductById(Cart.getProductid())));
		return p;
	}

	

}
