package com.masai.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.masai.entity.Address;
import com.masai.entity.Customer;
import com.masai.entity.Order;
import com.masai.entity.Product;

@Repository
public interface OrderDao extends JpaRepository<Order, Integer> {

	public List<Order> findByOrderDate(LocalDate orderDate);
	public List<Order> findByOrderStatus(String orderStatus);
	
	@Query("select p from Order o JOIN o.productlist p where o.orderId=:id")
	public List<Product> getProductdetailsByOrderId(@Param("id") Integer id);
	
	@Query("select p.productName from Order o JOIN o.productlist p where o.orderId=:id")
	public List<String> getProductNameByOrderId(@Param("id") Integer id);
	
	@Query("select p.productName from Order o JOIN o.productlist p where o.orderStatus=:status")
	public List<String> getProductNameByOrderStatus(@Param("status") String status);

	@Query("select a from Order o JOIN o.address a where o.orderId=:id")
	public Address getAddressByOrderId(@Param("id") Integer id);
	
	@Query("select c from Order o JOIN o.customer c where o.orderId=:id")
	public Customer getCustomerByOrderId(@Param("id") Integer id);
}
