package com.ispan.eeit.model;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="shoppingCart")
public class ShoppingCart implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer serial;
	private Integer shoppingCarId;
	private String userName;
	private String phoneNumber;
	private Blob serviceImg;
	private String serviceName;
	private Date servicePeriod;
	private Integer price;
	private String variety;
	private Integer payment;
	
	public ShoppingCart() {
		super();
	}

	public ShoppingCart(Integer shoppingCarId, String userName, String phoneNumber, Blob serviceImg, String serviceName,
			Date servicePeriod, Integer price, String variety, Integer payment) {
		super();
		this.shoppingCarId = shoppingCarId;
		this.userName = userName;
		this.phoneNumber = phoneNumber;
		this.serviceImg = serviceImg;
		this.serviceName = serviceName;
		this.servicePeriod = servicePeriod;
		this.price = price;
		this.variety = variety;
		this.payment = payment;
	}

	public Integer getShoppingCarId() {
		return shoppingCarId;
	}

	public void setShoppingCarId(Integer shoppingCarId) {
		this.shoppingCarId = shoppingCarId;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	
} 