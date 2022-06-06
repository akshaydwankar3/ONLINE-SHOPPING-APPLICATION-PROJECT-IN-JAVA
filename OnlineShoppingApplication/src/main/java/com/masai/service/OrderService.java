package com.masai.service;

import java.time.LocalDate;
import java.util.List;

import com.masai.entity.Order;
import com.masai.exception.OrderNotFoundException;
import com.masai.exception.ProductNotFoundException;

public interface OrderService {

    public Order saveOrder(Order order);
	
	public Order getOrderById(Integer id)throws OrderNotFoundException;
	
	public List<Order> getAllOrders() throws OrderNotFoundException;
	
	public Order deleteOrderById(Integer id)throws OrderNotFoundException;
	
	public Order updateOrder(Order order) throws OrderNotFoundException;
	
//	public Order updateOrderPrice(Integer id, Double addPrice)throws OrderNotFoundException;
//	
    public List<Order> getOrderDetailsByOrderDate(LocalDate date) throws OrderNotFoundException;
	
	public List<Order> getOrderDetailsByStatus(String status) throws OrderNotFoundException;
	
	
	
}