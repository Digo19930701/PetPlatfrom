package com.example.ECPayDemo.bean;

import java.sql.Blob;
import java.sql.Date;

public class CarDataBean {
	private Blob serviceImg;
	private String serviceName;
	private Date servicePeriod;
	private int price;
	private int payment;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPayment() {
		return payment;
	}
	public void setPayment(int payment) {
		this.payment = payment;
	}
	
}
