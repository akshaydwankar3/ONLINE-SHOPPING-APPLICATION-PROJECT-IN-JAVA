package com.masai.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entity.Order;
import com.masai.entity.Product;
import com.masai.exception.OrderNotFoundException;
import com.masai.reopsitory.OrderDao;
import com.masai.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	private OrderDao oDao;
	@Autowired
	private OrderService oService;
	
	@PostMapping("/orders")
	public ResponseEntity<Order> saveOrders(@RequestBody Order order){
		 Order saveorder=oService.saveOrder(order);
		return new ResponseEntity<Order>(saveorder,HttpStatus.CREATED);
	}
	
	@GetMapping("/orders/{orderId}")
	public Order getProductById(@PathVariable("orderId") Integer id) {
		return oService.getOrderById(id);
	}
	
	@GetMapping("/orders")
	public ResponseEntity<List<Order>> getAllOrders(){
		List<Order> orders=oService.getAllOrders();
		
		return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);
	}
	
	@DeleteMapping("/orders/{orderId}")
	public Order deleteProductById(@PathVariable("orderId") Integer id) {
		return oService.deleteOrderById(id);
	}
	
	@PutMapping("/orders")
	public ResponseEntity<Order> updateOrderDetails(@RequestBody Order order){
		Order ord= oService.updateOrder(order);
		return new ResponseEntity<Order>(ord,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/productbyorderId/{orderId}")
	public List<Product> getProductbyOrderId(@PathVariable("orderId") Integer id) {
		List<Product> plist=oDao.getProductdetailsByOrderId(id);
		if(plist.size()>0) {
			return plist;
		}
		else {
			throw new OrderNotFoundException("Order id is not found with is id :"+id);
		}
	}
	
	@GetMapping("/productnamebyorderId/{orderId}")
	public List<String> getProductNamebyOrderId(@PathVariable("orderId") Integer id) {
		List<String> pNameList=oDao.getProductNameByOrderId(id);
		if(pNameList.size()>0) {
			return pNameList;
		}
		else {
			throw new OrderNotFoundException("Order id is not found with is id :"+id);
		}
	}
	
	@GetMapping("/productnamebystatus/{orderStatus}")
	public List<String> getProductNamebyStatus(@PathVariable("orderStatus") String status) {
		List<String> pNameList=oDao.getProductNameByOrderStatus(status);
		if(pNameList.size()>0) {
			return pNameList;
		}
		else {
			throw new OrderNotFoundException("Order id is not found with is status:"+status);
		}
	}
	
	@GetMapping("/orderstatus/{productName}")
	public List<String> getOrderStatus(@PathVariable("productName") String name) {
		List<String> orderSt=oDao.getOrderStatusByProductName(name);
		if(orderSt.size()>0) {
			return orderSt;
		}
		else {
			throw new OrderNotFoundException(name+ " Order is not delevered");
		}
	}
	
	
	
	@GetMapping("/getorderbydate/{orderDate}")
	public List<Order> getOrderDetailbyDate(@PathVariable("orderDate") LocalDate date){
		
		return oService.getOrderDetailsByOrderDate(date);
	}
	
	@GetMapping("/getorderbystatus/{orderStatus}")
	List<Order> getOrderDetailsByStatus(@PathVariable("orderStatus") String status){
		return oService.getOrderDetailsByStatus(status);
	}
}

