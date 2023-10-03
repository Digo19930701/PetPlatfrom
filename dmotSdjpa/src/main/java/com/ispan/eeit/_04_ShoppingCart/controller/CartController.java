package com.ispan.eeit._04_ShoppingCart.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ispan.eeit._04_ShoppingCart.model.Cart;
import com.ispan.eeit._04_ShoppingCart.service.CartService;


@RestController
@CrossOrigin("http://localhost:5173")
public class CartController {
	
	
	Logger log = LoggerFactory.getLogger(CartController.class);

	CartService shoppingCartService;
	
//	@Autowired
	public CartController(CartService shoppingCartService) {
		this.shoppingCartService = shoppingCartService;
	}
	
	@GetMapping("/shoppingCart/{shoppingCartId}")
	public Cart getUserName(@PathVariable String shoppingCartId, Model model) {
		Cart shoppingCart = shoppingCartService.getUserName(shoppingCartId);
		model.addAttribute("previous_userName",shoppingCart.getUserName());
		log.info("get " + shoppingCartId + " info.");
		return shoppingCart;
	}
	
//	@GetMapping("/sellers/{sellerId}")
//	public ResponseEntity<Seller> getSellerById(@PathVariable String sellerId) {
//		Seller seller = sellerService.getSellerById(sellerId);
//		if(seller != null){
//			log.info("found seller.");
//			return ResponseEntity.status(HttpStatus.OK).body(seller);
//		}else{
//			log.info("seller not found.");
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//		}
//	}
}