package com.ispan.eeit69.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

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
