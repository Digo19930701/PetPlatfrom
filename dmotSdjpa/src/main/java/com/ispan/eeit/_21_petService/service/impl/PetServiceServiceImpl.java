package com.ispan.eeit._21_petService.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ispan.eeit._21_petService.dao.PetServiceDao;
import com.ispan.eeit._21_petService.dao.PetServiceRepository;
import com.ispan.eeit._21_petService.model.PetService;
import com.ispan.eeit._21_petService.service.PetServiceService;

@Service
@Transactional
public class PetServiceServiceImpl implements PetServiceService{
	
	PetServiceDao petServiceDao;
	PetServiceRepository petServiceRepository;
	Logger log = LoggerFactory.getLogger(PetServiceServiceImpl.class);
	
	public PetServiceServiceImpl(PetServiceDao petServiceDao, PetServiceRepository petServiceRepository) {
		this.petServiceDao = petServiceDao; 
		this.petServiceRepository = petServiceRepository; 
	}
	
	@Override
	public PetService getServiceById(String serviceId) {
		return  petServiceDao.getServiceById(serviceId);
	}

	@Override
	public void save(PetService petService) {
		petServiceRepository.save(petService);
	}

}
