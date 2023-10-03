package com.ispan.eeit._01_register.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ispan.eeit._01_register.model.Memberfor4A2B;

@RestController
public class RegisterMemberController {
	private static Logger log = LoggerFactory.getLogger(RegisterMemberController.class);
	
	@PostMapping("/RegisterMember")
	public String registermember(@RequestBody  Memberfor4A2B memberfor4A2B){
		System.out.println(memberfor4A2B.getUserPassword());
		System.out.println(memberfor4A2B.getUserEmail());
		
		return "test OK" ;
		
	}
	
}
