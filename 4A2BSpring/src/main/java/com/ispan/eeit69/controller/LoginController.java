package com.ispan.eeit69.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ispan.eeit69.dao.UserDao;
import com.ispan.eeit69.entity.User;
import com.ispan.eeit69.service.EmailService;
import com.ispan.eeit69.service.UserService;



@RestController
@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
public class LoginController {

	   @Autowired
	   UserDao userDao;
	   
	   @Autowired
	   UserService userService;
	   
	   @Autowired
	   EmailService emailService;
	   
	   @Autowired
	   private RestTemplate restTemplate;
	    
	
	    @PostMapping("/Login")
	    @ResponseBody
		public String Login(@RequestParam("userEmail") String userEmail,
				@RequestParam("password") String password,Model model) {
		

	     //裝前端的帳號密碼並組合一個Bean
	     User user = new User();
	     user.setUserEmail(userEmail);
	     user.setPassword(password);
	     
	     
	     System.out.println("userService="+userService.LoginService(user));
	     
	     if(userService.LoginService(user)==true) {
	    	 
	    	 String yyy = userEmail;
//	    	 String vueAppUrl = "http://localhost:5173/Member"; // 替换成您的Vue.js应用程序的URL
//	         String responseData = restTemplate.getForObject(vueAppUrl, yyy);
//	         
//	         // 将数据添加到Model中
	         model.addAttribute("data", yyy);
	         emailService.sendForgotPasswordEmail(userEmail);
	        
	         return "http://localhost:5173/Member";
	    	 
	    	 
	     }
	     
	     return "登入失敗請在確認帳號密碼";
	   
	     
	    }   
}
	
	

