package com.ispan.eeit._04_ShoppingCart.controller;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ispan.eeit._04_ShoppingCart.service.impl.EcPayService;
import com.ispan.eeit._04_ShoppingCart.model.Cart;

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
	
	@GetMapping("/ecpayCheckout_by_cars")
	public String ecpayCheckout_by_cars(
		@RequestParam String price
		
	) {
		String aioCheckOutALLForm = ecPayService.ecpayCheckout_by_cars(price);
		
		return aioCheckOutALLForm;
	}
	
}