package com.ispan.eeit69;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
public class RegisterController {
	
	@RequestMapping(method = RequestMethod.POST, value="/Register")
	@ResponseBody
	public String Login(@RequestParam("UserEmail") String UserEmail,
			@RequestParam("userPassword") String userPassword,
			@RequestParam("useragainPasswordPassword") String useragainPasswordPassword) {
		
		System.out.println("信箱="+UserEmail);
	     System.out.println("密碼="+userPassword); 
	     System.out.println("確認密碼="+useragainPasswordPassword); 
		
	     return "登入";
	}
	
}
