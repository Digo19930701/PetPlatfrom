package com.example.ECPayDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ECPayDemo.service.OrderService;

@RestController
@CrossOrigin("http://localhost:5173")
public class OrderController {
	
	@Autowired
	OrderService orderService;

	@GetMapping("/ecpayCheckout")
	public String ecpayCheckout() {
		String aioCheckOutALLForm = orderService.ecpayCheckout();
		
		return aioCheckOutALLForm;
	}

	
	
}
