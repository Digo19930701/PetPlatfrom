package com.ispan.eeit._01_register.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ispan.eeit._01_register.model.User;



public interface UserDao extends JpaRepository<User, Integer>{
	
	//SQL語法
	@Query(value = "SELECT COUNT(*) FROM useraccount WHERE userEmail = :userEmail", nativeQuery = true)
	int countByUserEmail(@Param("userEmail") String userEmail);
	  
	//SQL語法
	@Query(value = "SELECT COUNT(*) FROM useraccount WHERE userPassword = :userPassword", nativeQuery = true)
	int countByPassword(@Param("userPassword") String userPassword);
	
	@Query(value = "SELECT * FROM useraccount WHERE userEmail = :userEmail", nativeQuery = true)
	User findUser(@Param("userEmail") String userEmail);
	// 1.SQL語法 在資料庫的指令
	// 2.HQL語法 在JAVA後端使用Hibenate框架的語言
	// 3.JPQL語法 在JAVA後端使用Jpa框架的語言
	
	
}