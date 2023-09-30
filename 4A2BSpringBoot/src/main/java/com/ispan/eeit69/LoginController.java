package com.ispan.eeit69;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
public class LoginController {

//    @Autowired
//	UserDao ud ;
	
//	@RequestMapping(method = RequestMethod.POST, value="/Login")
	@PostMapping("/Login")
	@ResponseBody
//	  public String Login(@RequestParam User user) {
//		public String Login(RequestParam User user) {
		 //public String Login(@RequestParam("account") String account,@RequestParam("password") String password) {
		public String Login(@RequestParam("account") String account,@RequestParam("password") String password) {
		System.out.println("API成功打入!=");
      // 假设LoginRequest是一个包含account和password字段的Java类
//      String account = user.getAccount();
//      String password = user.getPassword();
	     System.out.println("account="+account);
	     System.out.println("password="+password); 
	     
	     //裝前端的帳號密碼並組合一個Bean
//	     User user = new User();;
//	     user.setAccount(account);
//	     user.setPassword(password);
//	     
//	     //判斷資料庫帳密是否正確
//	     //撈資料庫的list 資料
//	     List<User> uerSQLDate = ud.findAll();
//	     
//	     int userBySQLAccount = ud.countByUser(account);
//	     int userBySQLPassword = ud.countByUser(password);
//	     
//	     if(userBySQLAccount>0&&userBySQLPassword>0) {
//	    	 
//	    		return "登入成功";
//	    	 
//	     }
	     	
		return "登入";
	  }
	
	
	
}
