package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.masai.entity.Cart;
import com.masai.entity.Customer;
import com.masai.entity.Product;

@Repository
public interface CartDao extends JpaRepository<Cart, Integer> {

//	public 
	@Query("select p from Cart c JOIN c.products p where p.productId=:id")
	public Product getproductByProductId(@Param("id") Integer id);
	
	
	@Query("select c.id from Cart c JOIN c.customer a where a.mobileNumber=:mobile")
	public Integer getIdByMobile(@Param("mobile") String mobile);
	
	@Query("select c.id from Cart c JOIN c.products p where p.productId=:id")
	public Integer getIdByPid(@Param("id") Integer pId);
	
	
}
