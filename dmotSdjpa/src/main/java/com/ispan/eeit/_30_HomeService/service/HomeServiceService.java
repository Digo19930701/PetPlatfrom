package com.ispan.eeit._30_HomeService.service;

import java.util.List;

import com.ispan.eeit._30_HomeService.model.HomeService;

public interface HomeServiceService {
	
	List<HomeService> getHomeService();
	
	HomeService getHomeServiceById(String serviceId);
}
