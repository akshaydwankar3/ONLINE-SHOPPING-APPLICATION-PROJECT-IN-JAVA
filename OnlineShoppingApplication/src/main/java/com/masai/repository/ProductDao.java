package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.masai.dto.ProductDTO;
import com.masai.entity.Product;



@Repository
public interface ProductDao extends JpaRepository<Product, Integer>  {

	public List<Product> findByProductName(String name);
	
	public List<Product> findByProductNameOrPrice(String name, Double price);
	
	public List<Product> findByProductNameAndPrice(String name, Double price);
	
	@Query("select p.productName from Product p where p.productId=:id")
	public String getProductsNameById(@Param("id") Integer id);
	
	@Query("select new com.masai.dto.ProductDTO(p.productName,p.price) from Product p where p.productName=:name")
	    public List<ProductDTO> getProductNameAndMarksById(@Param("name") String name);
	
	@Query("select p.productName from Product p where p.price<:price")
	public List<String> getProductnameByPrice(@Param("price") Double price);
}
