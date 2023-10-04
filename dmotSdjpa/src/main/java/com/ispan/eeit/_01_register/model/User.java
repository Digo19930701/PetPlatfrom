package com.ispan.eeit._01_register.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "useraccount", uniqueConstraints = {@UniqueConstraint(columnNames = "userEmail")})
public class User {
	
	 
//	 @GeneratedValue(strategy = GenerationType.IDENTITY)
//	 @Column(name = "Id", nullable = false, insertable = false, updatable = false)
//	 private Integer id;
	 
	 @Id
	 private String userEmail;
	 private String userPassword;
	 private String userPassword2;
	 private String userName;
	 private String userId;
	 private String userPhone;

	public String getUserEmail() {
		return userEmail;
	}


	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}


	public String getUserPassword() {
		return userPassword;
	}


	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}


	public String getUserPassword2() {
		return userPassword2;
	}


	public void setUserPassword2(String userPassword2) {
		this.userPassword2 = userPassword2;
	}
	 
	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getUserPhone() {
		return userPhone;
	}


	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	
	 

	 
	 
}
