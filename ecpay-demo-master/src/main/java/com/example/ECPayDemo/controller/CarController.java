package com.example.ECPayDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ECPayDemo.CarRepositery;
import com.example.ECPayDemo.CarTest;

@RestController
@CrossOrigin("http://localhost:5173")
public class CarController {
	@Autowired
	private CarRepositery carRepositery;
	@GetMapping("/cardata")
	public String insert(@RequestBody CarTest cardata) {

		carRepositery.save(cardata);

		return "執行資料庫的 Create 操作";
	}
	
//	private CarDataBean cardata;
//	private CarDataBean2 cardata2;
//	@GetMapping("/items")
//	public CarDataBean getAllCars() {
//		cardata = new CarDataBean();
////		cardata.setServiceImg();
//		cardata.setServiceName("服務");
////		cardata.setServicePeriod();
//		cardata.setPrice(30);
//		cardata.setPayment(30);
//
//		cardata2 = new CarDataBean2();
//		cardata2.setUserName("L");
//		cardata2.setPhoneNumber("0800123456");
//		cardata2.setVariety("英短");
//		cardata2.setPersonAlity("火爆");
//		cardata2.setPetAge(30);
//		cardata2.setOrderMsg("貪吃鬼");
//		cardata2.setPayment(30);
//		
//		return cardata;
//	}
	
}
