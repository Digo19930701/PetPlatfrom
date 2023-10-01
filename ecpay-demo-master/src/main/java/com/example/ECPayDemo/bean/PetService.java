package com.example.ECPayDemo.bean;

import java.io.Serializable;
import java.sql.Time;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="services")
public class PetService implements Serializable{
	private static final long serialVersionUID = 1L;
	String serviceName;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer serviceId;
	String sellerId;
	String category;
	String serviceDesc;
	Time servicePeriod;
	Integer upperLimit;
//	List<Boolean> availDayList;
	Time availTime1;
	Time availTime2;
	Integer acceptDay1;
	Integer acceptDay2;
	List<String> serviceImageList;
//	List<Integer> typeIdList;
	
	public PetService() {
		super();
	}
	
	public PetService(String serviceName, Integer serviceId, String sellerId,
					String category, String serviceDesc, Time servicePeriod, Integer upperLimit, 
					Time availTime1,Time availTime2,
					Integer acceptDay1, Integer acceptDay2, List<String> serviceImageList) {
		super();
		this.serviceName = serviceName;
		this.serviceId = serviceId;
		this.sellerId = sellerId;
		this.category = category;
		this.serviceDesc = serviceDesc;
		this.servicePeriod = servicePeriod;
		this.upperLimit = upperLimit;
//		this.availDayList = availDayList;
		this.availTime1 = availTime1; 
		this.availTime2 = availTime2; 
		this.acceptDay1 = acceptDay1;
		this.acceptDay2 = acceptDay2;
		this.serviceImageList = serviceImageList;
//		this.typeIdList = typeIdList;
	}
	
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public Integer getServiceId() {
		return serviceId;
	}
	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}
	public String getSellerId() {
		return sellerId;
	}
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getServiceDesc() {
		return serviceDesc;
	}
	public void setServiceDesc(String serviceDesc) {
		this.serviceDesc = serviceDesc;
	}
	public Time getServicePeriod() {
		return servicePeriod;
	}
	public void setServicePeriod(Time servicePeriod) {
		this.servicePeriod = servicePeriod;
	}
	public Integer getUpperLimit() {
		return upperLimit;
	}
	public void setUpperLimit(Integer upperLimit) {
		this.upperLimit = upperLimit;
	}

	public Time getAvailTime1() {
		return availTime1;
	}
	public void setAvailTime1(Time availTime1) {
		this.availTime1 = availTime1;
	}
	public Time getAvailTime2() {
		return availTime2;
	}
	public void setAvailTime2(Time availTime2) {
		this.availTime2 = availTime2;
	}
	public Integer getAcceptDay1() {
		return acceptDay1;
	}
	public void setAcceptDay1(Integer acceptDay1) {
		this.acceptDay1 = acceptDay1;
	}
	public Integer getAcceptDay2() {
		return acceptDay2;
	}
	public void setAcceptDay2(Integer acceptDay2) {
		this.acceptDay2 = acceptDay2;
	}
	public List<String> getServiceImageList() {
		return serviceImageList;
	}
	public void setServiceImageList(List<String> serviceImageList) {
		this.serviceImageList = serviceImageList;
	}

	
}
