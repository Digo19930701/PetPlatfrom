package com.ispan.eeit._30_HomeService.model;

import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ispan.eeit._30_HomeService.constant.HomeServiceCategory;

@Entity
@Table(name = "services")
public class HomeService {

//	private static final long serialVersionUID = 1L;
	private String serviceName;
//		@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private String serviceId;
	private String sellerId;
	private HomeServiceCategory category;
	private String serviceDesc;
	private Time servicePeriod;
	private Integer upperLimit;
	private Time availTime1;
	private Time availTime2;
	private Integer acceptDay1;
	private Integer acceptDay2;
	private String serviceImage1;
	private String serviceImage2;
	private String serviceImage3;
	private String serviceImage4;
	private String serviceImage5;
	private boolean monday;
	private boolean tuesday;
	private boolean wednesday;
	private boolean thursday;
	private boolean friday;
	private boolean saturday;
	private boolean sunday;
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getServiceId() {
		return serviceId;
	}
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	public String getSellerId() {
		return sellerId;
	}
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	public HomeServiceCategory getCategory() {
		return category;
	}
	public void setCategory(HomeServiceCategory category) {
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
	public String getServiceImage1() {
		return serviceImage1;
	}
	public void setServiceImage1(String serviceImage1) {
		this.serviceImage1 = serviceImage1;
	}
	public String getServiceImage2() {
		return serviceImage2;
	}
	public void setServiceImage2(String serviceImage2) {
		this.serviceImage2 = serviceImage2;
	}
	public String getServiceImage3() {
		return serviceImage3;
	}
	public void setServiceImage3(String serviceImage3) {
		this.serviceImage3 = serviceImage3;
	}
	public String getServiceImage4() {
		return serviceImage4;
	}
	public void setServiceImage4(String serviceImage4) {
		this.serviceImage4 = serviceImage4;
	}
	public String getServiceImage5() {
		return serviceImage5;
	}
	public void setServiceImage5(String serviceImage5) {
		this.serviceImage5 = serviceImage5;
	}
	public boolean isMonday() {
		return monday;
	}
	public void setMonday(boolean monday) {
		this.monday = monday;
	}
	public boolean isTuesday() {
		return tuesday;
	}
	public void setTuesday(boolean tuesday) {
		this.tuesday = tuesday;
	}
	public boolean isWednesday() {
		return wednesday;
	}
	public void setWednesday(boolean wednesday) {
		this.wednesday = wednesday;
	}
	public boolean isThursday() {
		return thursday;
	}
	public void setThursday(boolean thursday) {
		this.thursday = thursday;
	}
	public boolean isFriday() {
		return friday;
	}
	public void setFriday(boolean friday) {
		this.friday = friday;
	}
	public boolean isSaturday() {
		return saturday;
	}
	public void setSaturday(boolean saturday) {
		this.saturday = saturday;
	}
	public boolean isSunday() {
		return sunday;
	}
	public void setSunday(boolean sunday) {
		this.sunday = sunday;
	}

}

