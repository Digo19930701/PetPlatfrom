package com.ispan.eeit._21_petService.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ispan.eeit._21_petService.dao.PetServiceDao;
import com.ispan.eeit._21_petService.dao.PetServiceRepository;
import com.ispan.eeit._21_petService.model.PetService;
import com.ispan.eeit._21_petService.model.PetServiceDetail;
import com.ispan.eeit._21_petService.service.PetServiceService;
import com.ispan.eeit._30_HomeService.model.HomeServiceType;

@Service
@Transactional
public class PetServiceServiceImpl implements PetServiceService{
	
	private PetServiceDao petServiceDao;
	private PetServiceRepository petServiceRepository;
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
	public PetServiceDetail getPSDByServiceId(String serviceId) {
		log.info("getPSDByServiceId of " + serviceId + ": ServiceImpl (start).");
		return petServiceDao.getPSDByServiceId(serviceId);
	}	

	@Override
	public List<HomeServiceType> getHstListByServiceId(String serviceId) {
		log.info("gethstListByServiceId of " + serviceId + ": ServiceImpl (start).");
		return petServiceDao.getHstListByServiceId(serviceId);
	}

	@Override
	public void save(PetService petService) {
		petServiceRepository.save(petService);
	}

	@Override
	public void update(PetService petService) {
		petServiceRepository.save(petService);
		
	}

	@Override
	public void deleteById(String serviceId) {
		petServiceRepository.deleteById(serviceId);	
	}

}
