package com.ispan.eeit._30_HomeService.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ispan.eeit._30_HomeService.dao.HomeServiceDao;
import com.ispan.eeit._30_HomeService.model.HomeService;
import com.ispan.eeit._30_HomeService.service.HomeServiceService;

@Component
public class HomeServiceServiceImpl implements HomeServiceService{

	@Autowired
	private HomeServiceDao homeServiceDao;
	
	@Override
	public HomeService getHomeServiceById(String serviceId) {
		// TODO Auto-generated method stub
		return homeServiceDao.getHomeServiceById(serviceId);
	}

}
