package com.example.ECPayDemo.controller;

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

import com.example.ECPayDemo.bean.PetService;
import com.example.ECPayDemo.service.PetServiceService;

@RestController
@CrossOrigin("http://localhost:5173/")
public class PetServiceController {
	
	Logger log = LoggerFactory.getLogger(SellerController.class);
	
	PetServiceService serviceService;
	
	public PetServiceController(PetServiceService serviceService) {
		this.serviceService = serviceService;
	}
	
	@GetMapping("/sellers/services/{serviceId}")
	public PetService getServiceById(@PathVariable String serviceId,
								  	Model model) {
		PetService petService = serviceService.getServiceById(serviceId);
//		System.out.println("petServiceId: " + serviceId);
		model.addAttribute("previous_service_id", serviceId);
		log.info("get serviceId: " + serviceId + ".");
		return petService;
	}
	
	
//	(required = false)
//	(defaultValue = "10", name = "newVarName")
	@RequestMapping("/getServices")
	public String getServiceId(@RequestParam String serviceId,
								@RequestParam String serviceName) {
		System.out.println("ServiceId: " + serviceId);
		System.out.println("serviceName: " + serviceName);
		return "[test] get service.";
	}
	
//	多個不管,少的會null
	@RequestMapping("/postServices")
	public String postServiceId(@RequestBody PetService service) {
		System.out.println("ServiceId: " + service.getServiceId());
		System.out.println("serviceName: " + service.getServiceName());
		return "[test] post service.";
	}
	
//	(name = "New-Var-Name")
	@RequestMapping("/rqServices")
	public String rqServices(@RequestHeader String info) {
		System.out.println("header info: " + info);
		return "[test] rqservice";
	}
	
//	少了error
	@RequestMapping("/getServices/{ServiceId}/{serviceName}")
	public String pvServices(@PathVariable Integer ServiceId,
							 @PathVariable String serviceName) {
		System.out.println("ServiceId: " + ServiceId);
		System.out.println("serviceName: " + serviceName);
		return "[test] PathVariable service";
	}
	
//	@GetMapping("/sellers/{sellerId}/services")
//	public String findSellerServices(@PathVariable String sellerId, Model model) {
//		Service services = ServiceDao.getSellerServices(sellerId);
//		model.addAttribute("previous_employee_id", services.get());
//		System.out.println("findSellerServices");		
//		return "showAllEmployees";
//	}
	
//	@GetMapping("/employee/queryEmployee")
//	public String findAll(Model model) {
//		List<Employee>  employees = employeeService.findAll();
//		model.addAttribute(employees);   // 使用預設的識別字串 "employeeList"
//		log.info("送出所有員工資料供showAllEmployees.jsp顯示");
//		// 下一行對應  /WEB-INF/views/showAllEmployees.jsp
//		return "showAllEmployees";    
//	}
	
}
