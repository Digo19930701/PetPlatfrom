package com.example.ECPayDemo.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ECPayDemo.bean.dataBean;



@RestController
@CrossOrigin("http://localhost:5173/")
public class MyController {

	private dataBean studentRecords;

	@GetMapping("/test")
	public String test() {
		System.out.println("test!");
		return "test";
	}


	@GetMapping("/student/allstudent")
	public dataBean getAllStudents() {
		studentRecords = new dataBean();
		studentRecords.setName("Ray");
		studentRecords.setAge(30);

		return studentRecords;
	}
}