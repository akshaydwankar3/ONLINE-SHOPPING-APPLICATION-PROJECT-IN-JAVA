package com.masai.reopsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.entity.Cart;

@Repository
public interface CartRepository  extends JpaRepository<Cart, Integer>{
//select sum(marks) from student;
//	@Query("select sum(Product.price) from Cart")
//	public Double getSum();

}
