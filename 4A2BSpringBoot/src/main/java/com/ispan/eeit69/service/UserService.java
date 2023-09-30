package com.ispan.eeit69.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ispan.eeit69.dao.UserDao;
import com.ispan.eeit69.entity.User;

@Service
public class UserService {
	
	@Autowired
	UserDao userDao;
	
	
	public boolean LoginService(User user) {

     System.out.println("userEmail="+user.getUserEmail());
     System.out.println("password="+user.getPassword()); 
     
     //判斷資料庫帳密是否正確
     //撈資料庫的list 資料
//     List<User> uerSQLDate = userDao.findAll();
     
     int userBySQLAccount = userDao.countByUserEmail(user.getUserEmail());
     int userBySQLPassword = userDao.countByPassword(user.getPassword());
     System.out.println("userBySQLAccount="+userBySQLAccount);
     System.out.println("userBySQLPassword="+userBySQLPassword);
     if(userBySQLAccount==1 && userBySQLPassword==1) {
    	 System.out.println("登入成功!!"); 
    	
	return true;
	
  }
     System.out.println("登入不成功!!"); 
	return false;
     
     
 }
	
	
	
	
	
	
}
