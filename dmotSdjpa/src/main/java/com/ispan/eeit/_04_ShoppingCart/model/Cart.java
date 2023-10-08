package com.ispan.eeit._04_ShoppingCart.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shoppingCart")
public class Cart {
	// private static final long serialVersionUID = 1L;

	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	// private Integer serial;
	@Id
	private String shoppingCarId;
	private String userEmail;
	private String phoneNumber;
	private String serviceImg;
	private String serviceName;
	private Date servicePeriod;
	private Integer price;
	private String variety;
	private Integer payment;
	public String getShoppingCarId() {
		return shoppingCarId;
	}
	public void setShoppingCarId(String shoppingCarId) {
		this.shoppingCarId = shoppingCarId;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getServiceImg() {
		return serviceImg;
	}
	public void setServiceImg(String serviceImg) {
		this.serviceImg = serviceImg;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
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
	public String getVariety() {
		return variety;
	}
	public void setVariety(String variety) {
		this.variety = variety;
	}
	public Integer getPayment() {
		return payment;
	}
	public void setPayment(Integer payment) {
		this.payment = payment;
	}

	

}