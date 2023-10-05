package com.ispan.eeit._30_HomeService.dao;

import java.util.List;

import com.ispan.eeit._30_HomeService.dto.HomeServiceQueryParams;
import com.ispan.eeit._30_HomeService.model.HomeService;

public interface HomeServiceDao {
	
	List<HomeService> getHomeService(HomeServiceQueryParams homeServiceQueryParams);
	
//	List<HomeService> getHomeService();
	
	HomeService getHomeServiceById(String serviceId);
}
