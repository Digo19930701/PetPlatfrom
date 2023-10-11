package com.ispan.eeit._30_HomeService.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.ispan.eeit._30_HomeService.dao.HomeServiceDao;
import com.ispan.eeit._30_HomeService.dto.HomeServiceQueryParams;
import com.ispan.eeit._30_HomeService.model.HomeService;
import com.ispan.eeit._30_HomeService.rowmapper.HomeServiceRowMapper;

@Component
public class HomeServiceDaoImpl implements HomeServiceDao {
	Logger log = LoggerFactory.getLogger(HomeServiceDaoImpl.class);
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<HomeService> getHomeService(HomeServiceQueryParams homeServiceQueryParams) {
		// TODO Auto-generated method stub
		String sql = "SELECT serviceName, serviceId, sellerId, category, "
				+ "serviceDesc, servicePeriod, upperLimit, availTime1, availTime2, "
				+ "acceptDay1, acceptDay2, serviceImage1, serviceImage2, "
				+ "serviceImage3, serviceImage4, serviceImage5, monday, tuesday, "
				+ "wednesday, thursday, friday, saturday, " + "sunday FROM services WHERE 1=1";

		Map<String, Object> map = new HashMap<>();

		if (homeServiceQueryParams.getCategory() != null) {
			sql = sql + " AND category = :category"; // 一定要留空白
			map.put("category", homeServiceQueryParams.getCategory().name());
		}

		if (homeServiceQueryParams.getSearch() != null) {
			sql = sql + " AND serviceName LIKE :search"; // 一定要留空白 // LIKE 模糊查詢
			map.put("search", "%" + homeServiceQueryParams.getSearch() + "%");
		}
		if (homeServiceQueryParams.getDayofweek() != null) {
			switch (homeServiceQueryParams.getDayofweek()) {
			case 0:
				sql = sql + " AND sunday = 1";
				break;
			case 1:
				sql = sql + " AND monday = 1";
				break;
			case 2:
				sql = sql + " AND tuesday = 1";
				break;
			case 3:
				sql = sql + " AND wednesday = 1";
				break;
			case 4:
				sql = sql + " AND thursday = 1";
				break;
			case 5:
				sql = sql + " AND friday = 1";
				break;
			case 6:
				sql = sql + " AND saturday = 1";
				break;
			}
//			sql = sql + " AND serviceName LIKE :Dayofweek";	//一定要留空白	// LIKE 模糊查詢
			map.put("dayofweek", "%" + homeServiceQueryParams.getDayofweek() + "%");
		}
		if (homeServiceQueryParams.getAvailTime() != null) {
			log.info("homeServiceQueryParams.getAvailTime()  " + homeServiceQueryParams.getAvailTime()  + "(start).");
			sql = sql + " AND availTime1 <= :availTime AND availTime2 >= :availTime"; // 一定要留空白
			map.put("availTime", homeServiceQueryParams.getAvailTime());
		}
		log.info("sql= " +sql);
		List<HomeService> homeServiceList = namedParameterJdbcTemplate.query(sql, map, new HomeServiceRowMapper());
		List<HomeService> homeServiceList2 =new ArrayList<>();
		homeServiceList2.add(homeServiceList.get(0));
		homeServiceList2.add(homeServiceList.get(1));
		homeServiceList2.add(homeServiceList.get(2));
		return homeServiceList2;
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
