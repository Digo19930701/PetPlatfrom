package com.ispan.eeit._21_petService.dao;

import java.util.List;

import com.ispan.eeit._21_petService.model.PetService;
import com.ispan.eeit._21_petService.model.PetServiceDetail;
import com.ispan.eeit._30_HomeService.model.HomeServiceType;

public interface PetServiceDao {

	PetService getServiceById(String serviceId);

	PetServiceDetail getPSDByServiceId(String serviceId);

	List<HomeServiceType> getHstListByServiceId(String serviceId);
}
