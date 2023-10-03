package com.ispan.eeit._01_register.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ispan.eeit._01_register.dao.UserDao;
import com.ispan.eeit._01_register.model.User;
import com.ispan.eeit._01_register.service.EmailService;
import com.ispan.eeit._01_register.service.UserService;





@RestController
@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
public class LoginController {

	   @Autowired
	   UserDao userDao;
	   
	   @Autowired
	   UserService userService;
	   
	   @Autowired
	   EmailService emailService;
	   
//	   @Autowired
//	   private RestTemplate restTemplate;
	    
	   
//	   @PostMapping("/Login1")
//	   @ResponseBody
//	   public String Login1(@RequestBody test id) {
//		   System.out.println(id.getId());
//		   return "test 測試成功"+id.getId() ;
//	   }
	   
	    @PostMapping("/Login")
	    @ResponseBody
		public String Login(@RequestBody User user ) {
		
	    	
	    	
//	     //裝前端的帳號密碼並組合一個Bean
//	     User user = new User();
	    	String userEmial = user.getUserEmail();
	    	String Password = user.getPassword();
	    	
	    	System.out.println("我是登入"+user.getPassword());
	     
//	     System.out.println("userService="+userService.LoginService(user));
//	     
	     if(userService.LoginService(user)==true) {
	    	 
//	    	 String yyy = userEmail;
//	    	 String vueAppUrl = "http://localhost:5173/Member"; // 替换成您的Vue.js应用程序的URL
//	         String responseData = restTemplate.getForObject(vueAppUrl, yyy);      
//	          //将数据添加到Model中
//	         model.addAttribute("data", yyy);
//	         emailService.sendForgotPasswordEmail(userEmail);
	        
	         return "http://localhost:5173/Member";
	    	 
	    	 
	     }
	     
	     return "http://localhost:5173";
	   
	     
	    }   
}
	
	

