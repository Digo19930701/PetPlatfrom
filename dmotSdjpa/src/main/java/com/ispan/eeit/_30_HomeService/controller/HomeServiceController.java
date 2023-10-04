package com.ispan.eeit._30_HomeService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ispan.eeit._30_HomeService.model.HomeService;
import com.ispan.eeit._30_HomeService.service.HomeServiceService;

@RestController
@CrossOrigin(origins = "http://localhost:5173/")
public class HomeServiceController {
	
	@Autowired
	private HomeServiceService homeServiceService;
	
	@GetMapping("/Home/services")
	public ResponseEntity<List<HomeService>> getHomeService(){
		List<HomeService> HomeServiceList = homeServiceService.getHomeService();
		
		return ResponseEntity.status(HttpStatus.OK).body(HomeServiceList);
	}
	
	
	@GetMapping("/Home/services/{serviceId}")
	public ResponseEntity<HomeService> getHomeService(@PathVariable String serviceId){
		HomeService homeService = homeServiceService.getHomeServiceById(serviceId);
		if(homeService != null) {
			return ResponseEntity.status(HttpStatus.OK).body(homeService);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
}
