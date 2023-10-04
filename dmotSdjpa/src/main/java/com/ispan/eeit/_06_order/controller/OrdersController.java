package com.ispan.eeit._06_order.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ispan.eeit._06_order.model.Order;
import com.ispan.eeit._06_order.service.OrdersService;


//@SessionAttributes({"LoginOK"})
@RestController
@CrossOrigin("http://localhost:5173/")
public class OrdersController {

	private static Logger log = LoggerFactory.getLogger(OrdersController.class);
	
	OrdersService orderService;
	
//	@Autowired
	public OrdersController(OrdersService orderService) {
		this.orderService = orderService;
	}
	
	@GetMapping("/sellers/order/{orderId}")
	public ResponseEntity<Order> getOrder(@PathVariable String orderId, Model model) {
		Order sellerOrder= orderService.getOrder(orderId);
		model.addAttribute("SellerOrder", orderId);
		if(sellerOrder != null) {
			log.info("get order of " + orderId + ".");			
			return ResponseEntity.status(HttpStatus.OK).body(sellerOrder);
		}else {			
			log.info(orderId + " is null.");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@GetMapping("/sellers/orderList/{sellerId}")
	public  ResponseEntity<List<Order>> getOrdersBySellerId(@PathVariable String sellerId){	
		List<Order> orderList = orderService.getOrdersBySellerId(sellerId);
		if(orderList != null) {
			return ResponseEntity.status(HttpStatus.OK).body(orderList);
		}else {			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
}
