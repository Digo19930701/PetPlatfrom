package com.ispan.eeit69.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ispan.eeit69.dao.UserDao;
import com.ispan.eeit69.entity.User;
import com.ispan.eeit69.service.UserService;



@RestController
@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
public class LoginController {

	   @Autowired
	   UserDao userDao;
	   
	   @Autowired
	   UserService userService;
	
	    @PostMapping("/Login")
	    @ResponseBody
		public String Login(@RequestParam("userEmail") String userEmail,@RequestParam("password") String password) {
		

	     //裝前端的帳號密碼並組合一個Bean
	     User user = new User();
	     user.setUserEmail(userEmail);
	     user.setPassword(password);
	     
	     
	     System.out.println("userService="+userService.LoginService(user));
	     
	     if(userService.LoginService(user)==true) {
	    	 return "登入成功";
	     }
	     
	     return "登入失敗請在確認帳號密碼";
	   
	     
	    }   
}
	
	

