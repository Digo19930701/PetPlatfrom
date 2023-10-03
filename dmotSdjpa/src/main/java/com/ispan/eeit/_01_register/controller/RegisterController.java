package com.ispan.eeit._01_register.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ispan.eeit._01_register.dao.UserDao;
import com.ispan.eeit._01_register.model.User;



@RestController
@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
public class RegisterController {
	
	@Autowired
	UserDao userDao;
	
	@PostMapping("/Register")
	@ResponseBody
	public String Register(@RequestBody User user) {
		
		System.out.println("userEmail="+user.getUserEmail());
    	System.out.println("userPassword="+user.getPassword());
    	System.out.println("userPassword2="+user.getPassword2());
		 return "OK";
	     
	     //密碼驗證
//	   if(userPassword.equals(userPassword2)) {
//	     User user = new User();
//	     user.setUserEmail(userEmail);
//	     user.setPassword(userPassword);
//	     
//	     System.out.println("user="+user); 
//	     userDao.save(user);
//	     
//	     return "註冊成功";
//	   }
//	   else {
//	   return "密碼確認不一致";
//	   }
	}
	
	
	
	
	
	
}
