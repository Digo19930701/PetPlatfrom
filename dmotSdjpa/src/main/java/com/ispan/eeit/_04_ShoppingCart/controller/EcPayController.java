package com.ispan.eeit._04_ShoppingCart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ispan.eeit._04_ShoppingCart.service.impl.EcPayService;


@RestController
@CrossOrigin("http://localhost:5173")
public class EcPayController {
	
	@Autowired
	EcPayService ecPayService;

	@GetMapping("/ecpayCheckout")
	public String ecpayCheckout() {
		String aioCheckOutALLForm = ecPayService.ecpayCheckout();
		
		return aioCheckOutALLForm;
	}

	
	
}