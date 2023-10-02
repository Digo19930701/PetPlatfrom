package com.ispan.eeit.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ispan.eeit.model.Employee;
import com.ispan.eeit.service.EmployeeService;

@Controller
public class FindEmployeeController extends AbstractController{
    
	Logger log = LoggerFactory.getLogger(FindEmployeeController.class);
	
	EmployeeService  employeeService;
	
//	@Autowired
	public FindEmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
    // 	查詢所有的員工資料             
	@GetMapping("/employee/queryEmployee")
	public String findAll(Model model) {
		List<Employee>  employees = employeeService.findAll();
		model.addAttribute(employees);   // 使用預設的識別字串 "employeeList"
		log.info("/employeesdjpa, 送出所有員工資料供showAllEmployees.jsp顯示");
		// 下一行對應  /WEB-INF/views/showAllEmployees.jsp
		return "showAllEmployees";    
	}
}
