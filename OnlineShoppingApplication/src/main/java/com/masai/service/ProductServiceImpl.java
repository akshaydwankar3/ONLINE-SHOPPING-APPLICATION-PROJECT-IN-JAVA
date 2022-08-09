package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entity.Product;
import com.masai.exception.ProductNotFoundException;
import com.masai.repository.ProductDao;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao pDao;
	@Override
	public Product saveProduct(Product product) {
	
		return pDao.save(product);
	}

	@Override
	public Product getProductById(Integer id) {
		return pDao.findById(id).orElseThrow(()-> new ProductNotFoundException("Product is not found with :"+id));
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> products=pDao.findAll();
	
		if(products.size()>0) {
			return products;
		}
		else {
			throw new ProductNotFoundException("No Product found");
		}
	}

	@Override
	public Product deleteProductById(Integer id) {
		Product existProduct= pDao.findById(id).orElseThrow(()-> new ProductNotFoundException("Product dose not exist with id :"+id));
		pDao.delete(existProduct);
		return existProduct;
	}

	@Override
	public Product updateProduct(Product product) {
		Optional<Product> opt=pDao.findById(product.getProductId());
		if(opt.isPresent()) {
			Product existProduct=opt.get();
			return pDao.save(product);
		}
		else {
			throw new ProductNotFoundException("Product is not exist..");
			
		}
		
	}

	@Override
	public Product updateProductPrice(Integer id, Double addPrice) throws ProductNotFoundException {
		Optional<Product> opt= pDao.findById(id);
		if(opt.isPresent()) {
			Product existProduct = opt.get();
			existProduct.setPrice(existProduct.getPrice()+addPrice);
			return pDao.save(existProduct);
		}
		else {
			throw new ProductNotFoundException("Product dose not exist with id :"+id);
		}
	}

	@Override
	public List<Product> getProductDetailsByName(String name) throws ProductNotFoundException {
		List<Product> products=pDao.findByProductName(name);
		if(products.size()>0) {
			return products;
		}
		else {
			throw new ProductNotFoundException("Product dose not exist with name :"+name);
		}
	}

	@Override
	public List<Product> getProductDetailsByNameOrPrice(String name, Double price) throws ProductNotFoundException {
		List<Product> products= pDao.findByProductNameOrPrice(name, price);
		if(products.size()>0) {
			return products;
		}
		else {
			throw new ProductNotFoundException("Product dose not exist by name or price");
			
		}
	}

	@Override
	public List<Product> getProductDetailsByNameAndPrice(String name, Double price) throws ProductNotFoundException {
		List<Product> products= pDao.findByProductNameAndPrice(name, price);
		if(products.size()>0) {
			return products;
		}
		else {
			throw new ProductNotFoundException("Product dose not exist by name and price");
		}
	}



}
