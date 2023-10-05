package com.ispan.eeit._01_register.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ispan.eeit._01_register.dao.SellerRegisterDao;
import com.ispan.eeit._01_register.dao.UserDao;
import com.ispan.eeit._01_register.model.User;
import com.ispan.eeit._31_seller.model.Seller;



@RestController
@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
public class RegisterController {
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	SellerRegisterDao sellerRegisterDao;
	
	@PostMapping("/Register")
	@ResponseBody
	public String Register(@RequestBody User user) {
		

		 String userEmail = user.getUserEmail();
		 String userPassword = user.getUserPassword();
		 String userPassword2 = user.getUserPassword2();
		 String userName = user.getUserName();
		 
		 System.out.println("我是使用者姓名"+user.getUserName());
		 System.out.println("我是使用者ID"+user.getUserId());
		 System.out.println("我是使用者電話"+user.getUserPhone());
		 
		 
	     //密碼驗證
	   if(userPassword.equals(userPassword2)) {
	     userDao.save(user);
	     return "註冊成功";
	   							}
	   else {
	   return "密碼確認不一致";
	   			}
	}
			
	//商家註冊
			@PostMapping("/SellerRegister")
			@ResponseBody
			public String SellerRegister(@RequestBody Seller seller) {
			
		
			 String sellerEmail = seller.getSellerId();
			 String sellerPassword = seller.getSellerPassword();
			 String sellerPassword2 = seller.getSellerPassword2();
			 String sellerName = seller.getSellerName();
			 
			 System.out.println("我是商家Email"+seller.getSellerId());
			 System.out.println("我是商家密碼"+seller.getSellerPassword());
			 System.out.println("我是商家密碼確認"+seller.getSellerPassword2());
			 System.out.println("我是商家名稱"+seller.getSellerName());
			 
		    //密碼驗證
		  if(sellerPassword.equals(sellerPassword2)) {
			  sellerRegisterDao.save(seller);
		    return "註冊成功";
		  }
		  else {
		  return "密碼確認不一致";
		  }
		}

}
