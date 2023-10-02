package com.ispan.eeit69.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ispan.eeit69.dao.UserDao;
import com.ispan.eeit69.entity.User;

@RestController
@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
public class RegisterController {
	
	@Autowired
	UserDao userDao;
	
	@PostMapping("/Register")
	@ResponseBody
	public String Register(@RequestParam("UserEmail") String UserEmail,
			@RequestParam("userPassword") String userPassword,
			@RequestParam("userPassword2") String userPassword2) {
		
		 System.out.println("信箱="+UserEmail);
	     System.out.println("密碼="+userPassword);
	     System.out.println("密碼確認"+userPassword2);
	     
	     //密碼驗證
	   if(userPassword.equals(userPassword2)) {
	     User user = new User();
	     user.setUserEmail(UserEmail);
	     user.setPassword(userPassword);
	     
	     System.out.println("user="+user); 
	     userDao.save(user);
	     
	     return "註冊成功";
	   }
	   else {
	   return "密碼確認不一致";
	   }
	}
	
	
	
	
	
	
}
