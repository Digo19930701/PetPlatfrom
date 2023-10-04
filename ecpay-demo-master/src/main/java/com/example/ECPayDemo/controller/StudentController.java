package com.example.ECPayDemo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ECPayDemo.bean.Student;

@RestController
public class StudentController {
	
	@PostMapping("/students")
	public String create(@RequestBody Student student) {
		return "執行資料create";
	}
	
	@GetMapping("/students/{studentId}")
	public String read(@PathVariable Integer studentId) {
		return "執行資料read";
	}
	
	@PutMapping("/students/{studentId}")
	public String update(@PathVariable Integer studentId,
						@RequestBody Student student) {
		return "執行資料update";
	}
	
	@DeleteMapping("/students/{studentId}")
	public String delete(@PathVariable Integer studentId) {
		return "執行資料delete";
	}
}
