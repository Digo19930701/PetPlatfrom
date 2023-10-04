package com.ispan.eeit._31_seller.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ispan.eeit._31_seller.model.Seller;
import com.ispan.eeit._31_seller.service.SellerService;

@RestController
@CrossOrigin("http://localhost:5173/")
public class SellerController {
	
	
	Logger log = LoggerFactory.getLogger(SellerController.class);

	SellerService sellerService;
	
//	@Autowired
	public SellerController(SellerService sellerService) {
		this.sellerService = sellerService;
	}
		
	@GetMapping("/sellers/{sellerId}")
	public ResponseEntity<Seller> getSellerById(@PathVariable String sellerId) {
		Seller seller = sellerService.getSellerById(sellerId);
		if(seller != null){
			log.info("found seller.");
			return ResponseEntity.status(HttpStatus.OK).body(seller);
		}else{
			log.info("seller not found.");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
}
