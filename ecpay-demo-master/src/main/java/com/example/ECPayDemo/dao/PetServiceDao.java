package com.example.ECPayDemo.dao;

import com.example.ECPayDemo.bean.PetService;

public interface PetServiceDao {

	PetService getServiceById(Integer serviceId);
//	Service getSellerServices(String SellerId);
}
