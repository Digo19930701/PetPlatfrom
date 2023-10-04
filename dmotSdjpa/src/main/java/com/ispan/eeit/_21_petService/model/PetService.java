package com.ispan.eeit._21_petService.model;

import java.io.Serializable;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="services")
public class PetService implements Serializable{
	private static final long serialVersionUID = 1L;
	private String serviceName;
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String serviceId;
	private String sellerId;
	private String category;
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
	
	public PetService() {
		super();
	}
	
	public PetService(String serviceName, String serviceId, String sellerId,
					String category, String serviceDesc, Time servicePeriod, Integer upperLimit, 
					Time availTime1,Time availTime2, Integer acceptDay1, Integer acceptDay2,
					String serviceImage1, String serviceImage2, String serviceImage3, String serviceImage4, String serviceImage5,
					boolean monday,	boolean tuesday, boolean wednesday, boolean thursday,
					boolean friday, boolean saturday, boolean sunday) {
		super();
		this.serviceName = serviceName;
		this.serviceId = serviceId;
		this.sellerId = sellerId;
		this.category = category;
		this.serviceDesc = serviceDesc;
		this.servicePeriod = servicePeriod;
		this.upperLimit = upperLimit;
		this.availTime1 = availTime1; 
		this.availTime2 = availTime2; 
		this.acceptDay1 = acceptDay1;
		this.acceptDay2 = acceptDay2;
		this.serviceImage1 = serviceImage1;
		this.serviceImage2 = serviceImage2;
		this.serviceImage3 = serviceImage3;
		this.serviceImage4 = serviceImage4; 
		this.serviceImage5 = serviceImage5;
		this.monday = monday;
		this.tuesday = tuesday;
		this.wednesday = wednesday;
		this.thursday = thursday;
		this.friday = friday;
		this.saturday = saturday;
		this.sunday = sunday;
	}
	
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
