package com.ispan.eeit._21_petService.dao;

import com.ispan.eeit._21_petService.model.PetService;

public interface PetServiceDao {

	PetService getServiceById(String serviceId);
//	Service getSellerServices(String SellerId);
}
