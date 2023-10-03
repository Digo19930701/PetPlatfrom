package com.ispan.eeit._01_register.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	 @Column(name = "userEmail", length = 50)
	 private String userEmail;
	 
	 @Column(name = "userPassWord", length = 20)
	 private String userPassword;
	 
	 @Column(name = "userPassWord2", length = 20)
	 private String userPassword2;


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
	 

	
	 

	 
	 
}
