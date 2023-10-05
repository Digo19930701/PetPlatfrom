package com.ispan.eeit._21_petService.service;

import com.ispan.eeit._21_petService.model.PetService;

public interface PetServiceService {	

	PetService getServiceById(String serviceId);

	void save(PetService petService);

	void update(PetService petService);

	void deleteById(String serviceId);

}
