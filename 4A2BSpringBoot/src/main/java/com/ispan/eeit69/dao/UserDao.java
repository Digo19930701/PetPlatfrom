package com.ispan.eeit69.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ispan.eeit69.entity.User;

public interface UserDao extends JpaRepository<User, Integer>{
	
	//SQL語法
	@Query(value = "SELECT COUNT(*) FROM user WHERE userEmail = :userEmail", nativeQuery = true)
	int countByUserEmail(@Param("userEmail") String userEmail);
	  
	//SQL語法
	@Query(value = "SELECT COUNT(*) FROM user WHERE password = :password", nativeQuery = true)
	int countByPassword(@Param("password") String password);
	
	
	// 1.SQL語法 在資料庫的指令
	// 2.HQL語法 在JAVA後端使用Hibenate框架的語言
	// 3.JPQL語法 在JAVA後端使用Jpa框架的語言
	
	
}