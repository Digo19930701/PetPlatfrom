package com.ispan.eeit._31_seller.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="sellerinfo")
public class Seller implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer serial;
	private String sellerId;
	private String sellerName;
	private String sellerDesc;
	private String sellerPhone;
	private String sellerAdd;
	private Integer unitTime;
	private String sellerImg;
	private String sellerPark;
	private String sellerPassword;
	
	public Seller() {
		super();
	}
	
	public Seller(String sellerId, String sellerName,
				  String sellerDesc,String sellerPhone,String sellerAdd,
				  Integer unitTime,String sellerImg,
				  String sellerPark, String sellerPassword) {
		super();
//		this.serial = serial;
		this.sellerId = sellerId;
		this.sellerName = sellerName;
		this.sellerDesc = sellerDesc;
		this.sellerPhone = sellerPhone;
		this.sellerAdd = sellerAdd;
//		this.sellerClass = sellerClass;
		this.unitTime = unitTime;
		this.sellerImg = sellerImg;
		this.sellerPark = sellerPark;
		this.sellerPassword = sellerPassword;
	}
	
	
	public String getSellerId() {
		return sellerId;
	}
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public String getSellerDesc() {
		return sellerDesc;
	}
	public void setSellerDesc(String sellerDesc) {
		this.sellerDesc = sellerDesc;
	}
	public String getSellerPhone() {
		return sellerPhone;
	}
	public void setSellerPhone(String sellerPhone) {
		this.sellerPhone = sellerPhone;
	}
	public String getSellerAdd() {
		return sellerAdd;
	}
	public void setSellerAdd(String sellerAdd) {
		this.sellerAdd = sellerAdd;
	}

	public Integer getUnitTime() {
		return unitTime;
	}
	public void setUnitTime(Integer unitTime) {
		this.unitTime = unitTime;
	}
	public String getSellerImg() {
		return sellerImg;
	}
	public void setSellerImg(String sellerImg) {
		this.sellerImg = sellerImg;
	}
	public String getSellerPark() {
		return sellerPark;
	}
	public void setSellerPark(String sellerPark) {
		this.sellerPark = sellerPark;
	}
	
	public String getSellerPassword() {
		return sellerPassword;
	}

	public void setSellerPassword(String sellerPassword) {
		this.sellerPassword = sellerPassword;
	}
}
