package com.ispan.eeit._04_ShoppingCart.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.ispan.eeit._04_ShoppingCart.dto.CartQueryParams;
import com.ispan.eeit._04_ShoppingCart.model.Cart;
import com.ispan.eeit._04_ShoppingCart.service.CartService;


@RestController
@CrossOrigin("http://localhost:5173")
public class CartController {
	
	
	Logger log = LoggerFactory.getLogger(CartController.class);

	@Autowired
	private CartService shoppingCartService;
	

	// public CartController(CartService shoppingCartService) {
	// 	this.shoppingCartService = shoppingCartService;
	// }
	@GetMapping("/shoppingCart")
	public ResponseEntity<List<Cart>> getshoppingCart(
			@RequestParam(required = false) String userEmail
	){
		CartQueryParams cartQueryParams = new CartQueryParams();
		cartQueryParams.setUserEmail(userEmail);
		
		List<Cart> shoppingCart = shoppingCartService.getshoppingCart(cartQueryParams);
		
		return ResponseEntity.status(HttpStatus.OK).body(shoppingCart);
	}	
	
	@GetMapping("/shoppingCart/{shoppingCartId}")
	public Cart getUserEmail(@PathVariable String shoppingCartId, Model model) {
		Cart shoppingCart = shoppingCartService.getUserEmail(shoppingCartId);
		model.addAttribute("previous_UserEmail",shoppingCart.getUserEmail());
		log.info("get " + shoppingCartId + " info.");
		return shoppingCart;
	}

}