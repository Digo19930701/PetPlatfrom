package com.ispan.eeit._06_order.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ispan.eeit._06_order.model.Order;
import com.ispan.eeit._06_order.service.OrdersService;


//@SessionAttributes({"LoginOK"})
@RestController("/sellers")
@CrossOrigin("http://localhost:5173/")
public class OrdersController {

	private static Logger log = LoggerFactory.getLogger(OrdersController.class);
	
	OrdersService orderService;
	
//	@Autowired
	public OrdersController(OrdersService orderService) {
		this.orderService = orderService;
	}

	@GetMapping("/orderList/{sellerId}")
	protected ResponseEntity<List<Order>> orderList(@PathVariable String sellerId, Model model) {
		List<Order> sellerOrders = orderService.getBySellerId(sellerId);
		model.addAttribute("memberOrders", sellerOrders);
		if(sellerOrders != null) {
			log.info("get coming orders of " + sellerId + ".");			
			return ResponseEntity.status(HttpStatus.OK).body(sellerOrders);
		}else {	
			log.info("商家:" + sellerId + "的訂單: " + sellerOrders);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
//		System.out.println(sellerOrders);
	}
	
	@GetMapping("/orderList/{orderId}")
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
	
}
