package com.ispan.eeit._21_petService.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ispan.eeit._21_petService.model.PetService;
import com.ispan.eeit._21_petService.service.PetServiceService;

@RestController
@CrossOrigin("http://localhost:5173/")
public class PetServiceController {
	
	Logger log = LoggerFactory.getLogger(PetServiceController.class);
	
	PetServiceService serviceService;
	
	public PetServiceController(PetServiceService serviceService) {
		this.serviceService = serviceService;
	}
	
	@GetMapping("/sellers/services/{serviceId}")
	public PetService getServiceById(@PathVariable String serviceId,
								  	Model model) {
		PetService petService = serviceService.getServiceById(serviceId);
		model.addAttribute("previous_service_id", serviceId);
		log.info("get serviceId: " + serviceId + ".");
		return petService;
	}
	
}
