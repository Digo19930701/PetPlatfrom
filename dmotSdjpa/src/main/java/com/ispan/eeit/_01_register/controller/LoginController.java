package com.ispan.eeit._01_register.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
		public ResponseEntity<User> Login(@RequestBody User user1,Model model) {
		
//	    	System.out.println("我是登入帳號"+user.getUserEmail());
//	    	System.out.println("我是登入密碼"+user.getUserPassword());

	     if(userService.LoginService(user1)==true) {
	    	 
//	    	 String yyy = user;
//	    	 String vueAppUrl = "http://localhost:5173/Member"; // 替换成您的Vue.js应用程序的URL
//	         String responseData = restTemplate.getForObject(vueAppUrl, yyy);      
//	          //将数据添加到Model中
//	         model.addAttribute("data", yyy);
//	         emailService.sendForgotPasswordEmail(user);
	    	 User user = userDao.findUser(user1.getUserEmail());
//	    	 model.addAttribute("user", user);
//	    	 return "redirect:/vueIndex";
	    	 return new ResponseEntity<>(user, HttpStatus.OK); 
	     }
//	     return "null";
	     return new ResponseEntity<>(user1, HttpStatus.BAD_REQUEST); 
	   
	     
	    }  
	    
	    
}
	
	

