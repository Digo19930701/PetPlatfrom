package com.ispan.eeit._06_order.dto;

public class OrderQueryParams {
	private String sellerId;
	private String orderId;
	private String userEmail;
	private Integer petNum;
	
	public String getSellerId() {
		return sellerId;
	}
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
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
	public Integer getPetNum() {
		return petNum;
	}
	public void setPetNum(Integer petNum) {
		this.petNum = petNum;
	}
	
	
	
}
