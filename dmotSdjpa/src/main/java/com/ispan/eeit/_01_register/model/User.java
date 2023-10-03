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

	
	 @Column(name = "userPassWord", length = 20)
	 private String password;
	

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	 
	 

	 
	 
}
