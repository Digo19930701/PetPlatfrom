package com.example.ECPayDemo.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ECPayDemo.bean.SellerOrder;
import com.example.ECPayDemo.bean.dataBean;



@RestController
@CrossOrigin("http://localhost:5173/")
public class MyController {

	private dataBean studentRecords;
	private SellerOrder sellerOrder1;

//	@GetMapping("/ordertest")
//	public SellerOrder getSellerOrder() {
////		System.out.println("ordertest!");
//		sellerOrder1 = new SellerOrder();
//		sellerOrder1.setOrderNum("20230927B000001");
//		sellerOrder1.setSellerId("raincatraindog@ispan.com");
//		sellerOrder1.setServiceName("洗澡啦!");
//		sellerOrder1.setCategory("美容");
//		sellerOrder1.setPetType("cat");
//		sellerOrder1.setSpec("長毛貓");
//		sellerOrder1.setPrice(450);
//		sellerOrder1.setUserEmail("user@ispan.com");
//		sellerOrder1.setUserName("趙一文");
//
//		
//		return sellerOrder1;
//	}


	@GetMapping("/student/allstudent")
	public dataBean getAllStudents() {
		studentRecords = new dataBean();
		studentRecords.setName("Ray");
		studentRecords.setAge(20);

		return studentRecords;
	}
}