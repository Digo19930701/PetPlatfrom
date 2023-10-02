package com.ispan.eeit._21_petService.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ispan.eeit._21_petService.dao.PetServiceDao;
import com.ispan.eeit._21_petService.model.PetService;
import com.ispan.eeit._21_petService.service.PetServiceService;

@Service
@Transactional
public class PetServiceServiceImpl implements PetServiceService{
	
	PetServiceDao petServiceDao;
	
	public PetServiceServiceImpl(PetServiceDao petServiceDao) {
		this.petServiceDao = petServiceDao; 
	}
	
	@Override
	public PetService getServiceById(String serviceId) {
		return  petServiceDao.getServiceById(serviceId);
	}

}
