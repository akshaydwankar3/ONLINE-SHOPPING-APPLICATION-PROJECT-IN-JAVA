package com.masai.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entity.Order;
import com.masai.entity.Product;
import com.masai.exception.OrderNotFoundException;
import com.masai.exception.ProductNotFoundException;
import com.masai.reopsitory.OrderDao;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao oDao;
	
	@Override
	public Order saveOrder(Order order) {
		Order ordersD= oDao.save(order);
		return ordersD;
	}

	@Override
	public Order getOrderById(Integer id){
		return oDao.findById(id).orElseThrow(()-> new OrderNotFoundException("Order not found. with id :"+id));
		
		
	}

	@Override
	public List<Order> getAllOrders() {
		List<Order> orderlist= oDao.findAll();
		if(orderlist.size()>0) {
			return orderlist;
		}
		else {
			throw new OrderNotFoundException("Order not found");
		}
	}

	@Override
	public Order deleteOrderById(Integer id)  {
	    Order existOrder= oDao.findById(id).orElseThrow(()-> new OrderNotFoundException("Order dose not exist with id :"+id));
	    oDao.delete(existOrder);
	    return existOrder;
	    
	}

	@Override
	public Order updateOrder(Order order){
		Optional<Order> opt=oDao.findById(order.getOrderId());
		if(opt.isPresent()) {
			Order existOrder=opt.get();
			return oDao.save(order);
		}
		else {
			throw new ProductNotFoundException("Order is not exist..");
			
		}
		
	}

	@Override
	public List<Order> getOrderDetailsByOrderDate(LocalDate date) {
		List<Order> opt=oDao.findByOrderDate(date);
		if(opt.size()>0) {
			return opt;
		}
		else {
			throw new OrderNotFoundException("Order dose not exist with date :"+date);
		}
		
	}

	@Override
	public List<Order> getOrderDetailsByStatus(String status) {
		List<Order> orderlist=oDao.findByOrderStatus(status);
		if(orderlist.size()>0) {
			return orderlist;
		}
		else {
			throw new OrderNotFoundException("order not found with status :"+status);
		}
	}

//	@Override
//	public Order updateOrderPrice(Integer id, Double addPrice) throws OrderNotFoundException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Order> getOrderDetailsByCustomerId(Integer id) throws OrderNotFoundException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Order> getOrderDetailsByCustomerNameAndcId(String name, Integer id) throws OrderNotFoundException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Order> getProductDetailsBycNameAndcId(String name, Double price) throws OrderNotFoundException {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
