package com.example.ECPayDemo.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ECPayDemo.bean.PetService;
import com.example.ECPayDemo.dao.PetServiceDao;
import com.example.ECPayDemo.service.PetServiceService;

@Service
@Transactional
public class PetServiceServiceImpl implements PetServiceService{
	
	PetServiceDao petServiceDao;
	
	public PetServiceServiceImpl(PetServiceDao petServiceDao) {
		this.petServiceDao = petServiceDao; 
	}
	
	@Override
	public PetService getServiceById(Integer serviceId) {
		return  petServiceDao.getServiceById(serviceId);
	}

}
