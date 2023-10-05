package com.ispan.eeit._30_HomeService.service;

import java.util.List;

import com.ispan.eeit._30_HomeService.constant.HomeServiceCategory;
import com.ispan.eeit._30_HomeService.model.HomeService;

public interface HomeServiceService {
	
	List<HomeService> getHomeService(HomeServiceCategory category, String search);
	
//	List<HomeService> getHomeService();
	
	HomeService getHomeServiceById(String serviceId);
}
