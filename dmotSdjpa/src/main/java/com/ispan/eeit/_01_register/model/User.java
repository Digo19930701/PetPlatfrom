package com.ispan.eeit._01_register.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "useraccount", uniqueConstraints = {@UniqueConstraint(columnNames = "userEmail")})
public class User {
	
	 @Id
	 @Column(name = "userEmail", length = 50)
	 private String userEmail;

	
	 @Column(name = "userPassword", length = 20)
	 private String userPassword;
	 
	 
	 private String userPassword2;
	 
	 public String getPassword2() {
		return userPassword2;
	}

	public void setPassword2(String userPassword2) {
		this.userPassword2 = userPassword2;
	}

	
	

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getPassword() {
		return userPassword;
	}

	public void setPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	 
	 

	 
	 
}
