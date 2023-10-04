package com.ispan.eeit._06_order.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ordertable")
public class Order {
	
	@Id
	String orderId;
	String userEmail;
	String sellerId ;
	Timestamp timeline1;
	Integer totalPrice;
	Integer petNum;
	String serviceId;
	Integer price;
	Timestamp orderDateTime1;
	Timestamp orderDateTime2;
	String orderMsg;
		
	public Order() {
		super();
	}
	
	public Order(String orderId, String userEmail, String sellerId, Timestamp timeline1,
					 Integer totalPrice, Integer petNum, String serviceId, Integer price,
					 Timestamp orderDateTime1, Timestamp orderDateTime2, String orderMsg) {
		super();
		this.orderId =orderId;
		this.userEmail = userEmail;
		this.sellerId = sellerId ;
		this.timeline1 = timeline1;
		this.totalPrice = totalPrice;
		this.petNum = petNum;
		this.serviceId = serviceId;
		this.price = price;
		this.orderDateTime1 = orderDateTime1;
		this.orderDateTime2 = orderDateTime2;
		this.orderMsg = orderMsg;
	}
	
	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public Timestamp getTimeline1() {
		return timeline1;
	}

	public void setTimeline1(Timestamp timeline1) {
		this.timeline1 = timeline1;
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Integer getPetNum() {
		return petNum;
	}

	public void setPetNum(Integer petNum) {
		this.petNum = petNum;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Timestamp getOrderDateTime1() {
		return orderDateTime1;
	}

	public void setOrderDateTime1(Timestamp orderDateTime1) {
		this.orderDateTime1 = orderDateTime1;
	}

	public Timestamp getOrderDateTime2() {
		return orderDateTime2;
	}

	public void setOrderDateTime2(Timestamp orderDateTime2) {
		this.orderDateTime2 = orderDateTime2;
	}

	public String getOrderMsg() {
		return orderMsg;
	}

	public void setOrderMsg(String orderMsg) {
		this.orderMsg = orderMsg;
	}
	
}
