package com.ispan.eeit._01_register.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ispan.eeit._01_register.dao.UserDao;
import com.ispan.eeit._01_register.model.User;



@Service
public class UserService {
	
	@Autowired
	UserDao userDao;
	
	
	public boolean LoginService(User user) {

    System.out.println("我是Sever userEmail="+user.getUserEmail());
    System.out.println("我是Sever password="+user.getPassword()); 
     
     //判斷資料庫帳密是否正確
     //撈資料庫的list 資料
//     List<User> uerSQLDate = userDao.findAll();
     
     int userBySQLAccount = userDao.countByUserEmail(user.getUserEmail());
     int userBySQLPassword = userDao.countByPassword(user.getPassword());
     System.out.println("userBySQLAccount="+userBySQLAccount);
     System.out.println("userBySQLPassword="+userBySQLPassword);
     if(userBySQLAccount>0 && userBySQLPassword>0) {
    	 System.out.println("登入成功!!"); 
    	
	return true;
	
  }
     System.out.println("登入成功!!"); 
	return false;
     
     
 }
	
	
	
	
	
	
}
