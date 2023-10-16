package com.ispan.eeit._01_register.service;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.ispan.eeit._01_register.dao.UserDao;
import com.ispan.eeit._01_register.model.User;



@Service
public class UserService {
	
	@Autowired
	UserDao userDao;
	
	
	public boolean LoginService(User user) {

     //判斷資料庫帳密是否正確
     //撈資料庫的list 資料
//     List<User> uerSQLDate = userDao.findAll();
     
     int userBySQLAccount = userDao.countByUserEmail(user.getUserEmail());
     String encodedData = DigestUtils.md5DigestAsHex(user.getUserPassword().getBytes());
     int userBySQLPassword = userDao.countByPassword(encodedData);
    
     System.out.println("userBySQLAccount="+userBySQLAccount);
     System.out.println("userBySQLPassword="+userBySQLPassword);
    
     if(userBySQLAccount>0 && userBySQLPassword>0) {
    	 System.out.println("登入成功!!"); 
    	
	return true;
	
  }
     System.out.println("登入不成功!!"); 
	return false;
     
     
 }
	
	
	
	
}
