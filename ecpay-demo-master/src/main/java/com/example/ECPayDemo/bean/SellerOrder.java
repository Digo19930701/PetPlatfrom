package com.example.ECPayDemo.bean;

import java.util.Date;

public class SellerOrder {
	String orderNum;
	String sellerId;
	Date orderTimeStart;	//要用sql還是util?
	Date orderTimeEnd;	//要用sql還是util?
	String category;
	
	
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public String getSellerId() {
		return sellerId;
	}
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	public Date getOrderTimeStart() {
		return orderTimeStart;
	}
	public void setOrderTimeStart(Date orderTimeStart) {
		this.orderTimeStart = orderTimeStart;
	}
	public Date getOrderTimeEnd() {
		return orderTimeEnd;
	}
	public void setOrderTimeEnd(Date orderTimeEnd) {
		this.orderTimeEnd = orderTimeEnd;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
}
