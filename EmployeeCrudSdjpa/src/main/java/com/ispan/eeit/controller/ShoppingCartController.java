package com.ispan.eeit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ispan.eeit.model.ShoppingCart;
import com.ispan.eeit.service.ShoppingCartService;


@RestController
@CrossOrigin("http://localhost:5173")
public class ShoppingCartController {
	
	
	Logger log = LoggerFactory.getLogger(ShoppingCartController.class);

	ShoppingCartService shoppingCartService;
	
//	@Autowired
	public ShoppingCartController(ShoppingCartService shoppingCartService) {
		this.shoppingCartService = shoppingCartService;
	}
	
	@GetMapping("/shoppingCart/{userName}")
	public ShoppingCart getUserName(@PathVariable String userName, Model model) {
		ShoppingCart shoppingCart = shoppingCartService.getUserName(userName);
		model.addAttribute("previous_userName",shoppingCart.getUserName());
		log.info("get " + userName + " info.");
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