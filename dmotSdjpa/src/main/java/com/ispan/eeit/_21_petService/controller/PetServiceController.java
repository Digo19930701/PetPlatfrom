package com.ispan.eeit._21_petService.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ispan.eeit._21_petService.model.PetService;
import com.ispan.eeit._21_petService.service.PetServiceService;

@RestController
@CrossOrigin("http://localhost:5173/")
public class PetServiceController {
	
	Logger log = LoggerFactory.getLogger(PetServiceController.class);
	
	PetServiceService pss;
	
	public PetServiceController(PetServiceService pss) {
		this.pss = pss;
	}
	
	@GetMapping("/sellers/services/{serviceId}")
	public PetService getServiceById(@PathVariable String serviceId,
								  	Model model) {
		PetService petService = pss.getServiceById(serviceId);
		model.addAttribute("previous_service_id", serviceId);
		log.info("get serviceId: " + serviceId + ".");
		return petService;
	}
	
	@PostMapping("/sellers/services")
	public ResponseEntity<PetService> createPetService(@RequestBody PetService petService, Model model){
		pss.save(petService);
		log.info("Controller---createPetService---: petService.getServiceId=" + petService.getServiceId() + ".");
		return ResponseEntity.status(HttpStatus.CREATED).body(petService);
	}
	
}
