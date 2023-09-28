package com.example.ECPayDemo;

import java.sql.Blob;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cardata")
public class CarTest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	Integer id;

	@Column(name = "serviceImg")
	Blob serviceImg;
	
	@Column(name = "serviceName")
	String serviceName;
	
	@Column(name = "petName")
	String petName;
	
	@Column(name = "servicePeriod")
	Date servicePeriod;
	
	@Column(name = "price")
	Integer price;
	
	@Column(name = "userName")
	String userName;
	
	@Column(name = "phoneNumber")
	String phoneNumber;
	
	@Column(name = "payment")
	Integer payment;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Blob getServiceImg() {
		return serviceImg;
	}

	public void setServiceImg(Blob serviceImg) {
		this.serviceImg = serviceImg;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public Date getServicePeriod() {
		return servicePeriod;
	}

	public void setServicePeriod(Date servicePeriod) {
		this.servicePeriod = servicePeriod;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Integer getPayment() {
		return payment;
	}

	public void setPayment(Integer payment) {
		this.payment = payment;
	}

	
	
}
