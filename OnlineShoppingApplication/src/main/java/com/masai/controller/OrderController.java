package com.masai.controller;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

import com.masai.entity.Address;
import com.masai.entity.Customer;
import com.masai.entity.Order;
import com.masai.entity.Product;
import com.masai.exception.OrderNotFoundException;
import com.masai.repository.OrderDao;
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
	
	@GetMapping("/getorderbydate/{String}")
	public List<Order> getOrderDetailbyDate(@PathVariable("orderDate") String date){
		DateTimeFormatter dfe= DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date1= LocalDate.parse(date, dfe);
		return oService.getOrderDetailsByOrderDate(date1);
	}
	
	@GetMapping("/getorderbystatus/{orderStatus}")
	List<Order> getOrderDetailsByStatus(@PathVariable("orderStatus") String status){
		return oService.getOrderDetailsByStatus(status);
	}
	
	@GetMapping("orderaddress/{orderId}")
	public Address getAddressDetails(@PathVariable("orderId") Integer id) {
		return oService.getAddressByOrderId(id);
		
	}
	
	@GetMapping("customerdetail/{orderId}")
	public Customer getCustomerDetails(@PathVariable("orderId") Integer id) {
		return oService.getCustomerByOrderId(id);
		
	}
}
