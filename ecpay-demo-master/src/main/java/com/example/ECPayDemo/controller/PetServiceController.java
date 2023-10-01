package com.example.ECPayDemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ECPayDemo.bean.PetService;
import com.example.ECPayDemo.dao.PetServiceDao;
import com.example.ECPayDemo.service.PetServiceService;

@RestController
@CrossOrigin("http://localhost:5173/")
public class PetServiceController {
	
//	@GetMapping("/services")
//	public Service serviceId() {
//		Service service = new Service();
//		service.setServiceId(1);
//		service.setSellerId("raincatraindog@ispan.com");
//		service.setServiceName("汪汪喵喵基礎沐浴美容");
//		service.setCategory("beauty");
//		service.setServiceDesc("很舒服");
//		service.setServicePeriod(60);
//		service.setUpperLimit(3);
//		List<Boolean> availDayList = new ArrayList<Boolean>();
//		availDayList.add(true);	//sunday
//		availDayList.add(false); //monday
//		availDayList.add(true);
//		availDayList.add(true); //wednesday
//		availDayList.add(true);
//		availDayList.add(true); //friday
//		availDayList.add(true);
//		service.setAvailDayList(availDayList);
//		
//		service.setAvailTime1("08:00");
//		service.setAvailTime2("20:00");
//		service.setAcceptDay1(30);
//		service.setAcceptDay2(3);
//		List<String> serviceImageList = new ArrayList<>();
//		serviceImageList.add("image1");
//		service.setServiceImageList(serviceImageList);
//		
//		List<Integer> typeIdList = new ArrayList<>();
//		typeIdList.add(1);
//		typeIdList.add(2);
//		service.setTypeIdList(typeIdList);
//
//		return service;
//	}
	Logger log = LoggerFactory.getLogger(SellerController.class);
	
	PetServiceService serviceService;
	
	public PetServiceController(PetServiceService serviceService) {
		this.serviceService = serviceService;
	}
	
	@GetMapping("/sellers/services")
	public PetService getServiceById(@PathVariable Integer serviceId,
								  	Model model) {
		PetService petService = serviceService.getServiceById(serviceId);
		System.out.println("petServiceId: " + serviceId);
		model.addAttribute("previous_service_id", serviceId);
		log.info("get serviceId: " + serviceId + ".");
		return petService;
	}
	
	
//	(required = false)
//	(defaultValue = "10", name = "newVarName")
	@RequestMapping("/getServices")
	public String getServiceId(@RequestParam Integer serviceId,
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
