package com.example.ECPayDemo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.ECPayDemo.bean.SellerOrder;
import com.example.ECPayDemo.service.SellerOrderService;

@RestController
@CrossOrigin("http://localhost:5173/")
public class SellerOrderController {
	
	Logger log = LoggerFactory.getLogger(SellerController.class);
	
	SellerOrderService sellerOrderService;
	
	public SellerOrderController(SellerOrderService sellerOrderService) {
		this.sellerOrderService = sellerOrderService;
	}

	@GetMapping("/sellers/orderList/{sellerId}")
	public List<SellerOrder> getSellerOrders(@PathVariable String sellerId, Model model) {
		List<SellerOrder> sellerOrders = sellerOrderService.getSellerOrders(sellerId);
		model.addAttribute(sellerOrders);
		log.info("get orders of seller(" + sellerId + ").");
		return sellerOrders;
	}
	
	@GetMapping("/sellers/orderList/coming/{orderId}")
	public SellerOrder getOrders(@PathVariable String orderId, Model model) {
		SellerOrder sellerOrder= sellerOrderService.getOrders(orderId);
		model.addAttribute("coming_SellerOrder", orderId);
		if(sellerOrder != null) {
			log.info("get coming orders of " + orderId + ".");			
		}else {			
			log.info(orderId + " is null.");
		}
		return sellerOrder;
	}

	
	
}
