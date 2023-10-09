package com.ispan.eeit._21_petService.service;

import java.util.List;

import com.ispan.eeit._21_petService.model.PetService;
import com.ispan.eeit._21_petService.model.PetServiceDetail;
import com.ispan.eeit._30_HomeService.model.HomeServiceType;

public interface PetServiceService {	

	PetService getServiceById(String serviceId);

	void save(PetService petService);

	void update(PetService petService);

	void deleteById(String serviceId);

	PetServiceDetail getPSDByServiceId(String serviceId);

	List<HomeServiceType> getHstListByServiceId(String serviceId);


}
