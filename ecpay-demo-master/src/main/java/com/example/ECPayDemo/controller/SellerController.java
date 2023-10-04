package com.example.ECPayDemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.ECPayDemo.bean.Seller;
import com.example.ECPayDemo.service.SellerService;

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
	public Seller getSellerById(@PathVariable String sellerId, Model model) {
		Seller seller = sellerService.getSellerById(sellerId);
		model.addAttribute("previous_seller_id",seller.getSellerId());
		log.info("get " + sellerId + " info.");
		return seller;
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
