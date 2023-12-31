package com.ispan.eeit._21_petService.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ispan.eeit._06_order.model.Order;
import com.ispan.eeit._21_petService.model.PetService;
import com.ispan.eeit._21_petService.model.PetServiceDetail;
import com.ispan.eeit._21_petService.service.PetServiceService;
import com.ispan.eeit._30_HomeService.model.HomeServiceType;

@RestController
@CrossOrigin("http://localhost:5173/")
public class PetServiceController {
	
	Logger log = LoggerFactory.getLogger(PetServiceController.class);
	
	PetServiceService pss;
	
	public PetServiceController(PetServiceService pss) {
		this.pss = pss;
	}
	
	@GetMapping("/sellers/serviceTypes/{serviceId}")
	public ResponseEntity<PetServiceDetail> getServicesById(@PathVariable String serviceId) {
		PetServiceDetail sellerPSD = pss.getPSDByServiceId(serviceId);
		List<HomeServiceType> hstList = pss.getHstListByServiceId(serviceId);
		if(sellerPSD != null) {
			sellerPSD.setHst(hstList);
			return ResponseEntity.status(HttpStatus.OK).body(sellerPSD);
		} else {
			return ResponseEntity.status(HttpStatus.OK).build();			
		}
	}
	
//	測試需求,實際上不太會用到
	@GetMapping("/sellers/HomeServiceTypes/{serviceId}")
	public ResponseEntity<List<HomeServiceType>> getHomeServicesById(@PathVariable String serviceId) {
		List<HomeServiceType> hstList = pss.getHstListByServiceId(serviceId);
		if(hstList != null) {
			return ResponseEntity.status(HttpStatus.OK).body(hstList);
		}else {			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@GetMapping("/sellers/services/{serviceId}")
	public PetService getServiceById(@PathVariable String serviceId) {
		PetService petService = pss.getServiceById(serviceId);
		log.info("petServiceController---getServiceById: serviceId=" + serviceId + ".");
		return petService;
	}
	
	@PostMapping("/sellers/services")
	public ResponseEntity<PetService> createPetService(@RequestBody PetService petService){
		pss.save(petService);
		log.info("petServiceController---createPetService: petService.getServiceId=" + petService.getServiceId() + ".");
		return ResponseEntity.status(HttpStatus.CREATED).body(petService);
	}
	
	@PutMapping("/sellers/services/{serviceId}")
	public ResponseEntity<PetService> updatePetService(@RequestBody PetService petService,
														@PathVariable String serviceId){
		// check exist.
		PetService Service = pss.getServiceById(serviceId);
        if (Service == null) {
        	log.info("petServiceController---updatePetService: 'NOT FOUND' petService.getServiceId=" + petService.getServiceId() + ".");
        	return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();        	
        } else {
        	pss.update(petService);		
        	log.info("petServiceController---updatePetService: petService.getServiceId=" + petService.getServiceId() + ".");
        	return ResponseEntity.status(HttpStatus.OK).body(petService);
        }
	}
	
	@DeleteMapping("/sellers/services/{serviceId}")
	public ResponseEntity<PetService> deletePetServiceById(@PathVariable String serviceId, Model model){
    	pss.deleteById(serviceId);
    	log.info("petServiceController---deletePetService: serviceId=" + serviceId + ".");
    	return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }	
	
	
	
}
