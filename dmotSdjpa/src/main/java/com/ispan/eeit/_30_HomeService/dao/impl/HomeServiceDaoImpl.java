package com.ispan.eeit._30_HomeService.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.ispan.eeit._30_HomeService.dao.HomeServiceDao;
import com.ispan.eeit._30_HomeService.dto.HomeServiceQueryParams;
import com.ispan.eeit._30_HomeService.model.HomeService;
import com.ispan.eeit._30_HomeService.rowmapper.HomeServiceRowMapper;

@Component
public class HomeServiceDaoImpl implements HomeServiceDao {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<HomeService> getHomeService(HomeServiceQueryParams homeServiceQueryParams) {
		// TODO Auto-generated method stub
		String sql = "SELECT serviceName, serviceId, sellerId, category, "
				+ "serviceDesc, servicePeriod, upperLimit, availTime1, availTime2, "
				+ "acceptDay1, acceptDay2, serviceImage1, serviceImage2, "
				+ "serviceImage3, serviceImage4, serviceImage5, monday, tuesday, "
				+ "wednesday, thursday, friday, saturday, "
				+ "sunday FROM services WHERE 1=1";

		Map<String, Object> map = new HashMap<>();
		
		if(homeServiceQueryParams.getCategory() != null) {
			sql = sql + " AND category = :category";	//一定要留空白
			map.put("category", homeServiceQueryParams.getCategory().name());
		}
		
		if(homeServiceQueryParams.getSearch() != null) {
			sql = sql + " AND serviceName LIKE :search";	//一定要留空白	// LIKE 模糊查詢
			map.put("search", "%" + homeServiceQueryParams.getSearch() + "%");	
		}

		List<HomeService> homeServiceList = namedParameterJdbcTemplate.query(sql, map, new HomeServiceRowMapper());

		return homeServiceList;
	}

//	@Override
//	public List<HomeService> getHomeService() {
//		// TODO Auto-generated method stub
//		String sql = "SELECT serviceName, serviceId, sellerId, category, serviceDesc, servicePeriod, upperLimit, availTime1, availTime2, acceptDay1, acceptDay2, serviceImage1, serviceImage2, serviceImage3, serviceImage4, serviceImage5, monday, tuesday, wednesday, thursday, friday, saturday, sunday FROM services";
//
//		Map<String, Object> map = new HashMap<>();
//
//		List<HomeService> homeServiceList = namedParameterJdbcTemplate.query(sql, map, new HomeServiceRowMapper());
//
//		return homeServiceList;
//	}

	@Override
	public HomeService getHomeServiceById(String serviceId) {
		// TODO Auto-generated method stub
		String sql = "SELECT serviceName, serviceId, sellerId, category, serviceDesc, servicePeriod, upperLimit, availTime1, availTime2, acceptDay1, acceptDay2, serviceImage1, serviceImage2, serviceImage3, serviceImage4, serviceImage5, monday, tuesday, wednesday, thursday, friday, saturday, sunday FROM services WHERE serviceId = :serviceId";
		Map<String, Object> map = new HashMap<>();
		map.put("serviceId", serviceId);

		List<HomeService> homeServiceList = namedParameterJdbcTemplate.query(sql, map, new HomeServiceRowMapper());

		if (homeServiceList.size() > 0) {
			return homeServiceList.get(0);
		} else {
			return null;
		}
	}

}
