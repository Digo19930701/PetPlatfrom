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
	    
	   
	   
	    @PostMapping("/Login")
	    @ResponseBody
		public String Login(@RequestBody User user,Model model ) {
		
	    	System.out.println("我是登入帳號"+user.getUserEmail());
	    	System.out.println("我是登入密碼"+user.getUserPassword());

	     System.out.println(userService.LoginService(user));
	     if(userService.LoginService(user)==true) {
	    	 
//	    	 String yyy = user;
//	    	 String vueAppUrl = "http://localhost:5173/Member"; // 替换成您的Vue.js应用程序的URL
//	         String responseData = restTemplate.getForObject(vueAppUrl, yyy);      
//	          //将数据添加到Model中
//	         model.addAttribute("data", yyy);
//	         emailService.sendForgotPasswordEmail(user);
	    	 
	         return "http://localhost:5173";
	    	 
	    	 
	     }
	     
	     return "登入失敗";
	   
	     
	    }   
}
	
	

