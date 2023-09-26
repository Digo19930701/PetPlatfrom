package com.example.ECPayDemo.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ECPayDemo.bean.dataBean;



@RestController
public class MyController {

	private dataBean studentRecords;

	@GetMapping("/test")
	public String test() {
		System.out.println("test!");
		return "test";
	}

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("eventName", "FIFA 2018");
		return "index";
	}

	@GetMapping("/student/allstudent")
	public dataBean getAllStudents() {
		studentRecords = new dataBean();
		studentRecords.setName("Ray");
		studentRecords.setAge(30);

		return studentRecords;
	}
}