package com.ispan.eeit._30_HomeService.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ispan.eeit._30_HomeService.constant.HomeServiceCategory;
import com.ispan.eeit._30_HomeService.model.HomeService;

public class HomeServiceRowMapper implements RowMapper<HomeService>{

	@Override
	public HomeService mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		HomeService homeService = new HomeService();
		homeService.setServiceId(rs.getString("serviceId"));
		homeService.setServiceName(rs.getString("serviceName"));
		homeService.setSellerId(rs.getString("sellerId"));
		
		String categoryStr = rs.getString("category");
		HomeServiceCategory category = HomeServiceCategory.valueOf(categoryStr);
		homeService.setCategory(category);
		
		
		homeService.setServiceDesc(rs.getString("serviceDesc"));
		homeService.setServicePeriod(rs.getTime("servicePeriod"));
		homeService.setUpperLimit(rs.getInt("upperLimit"));
		homeService.setAvailTime1(rs.getTime("availTime1"));
		homeService.setAvailTime2(rs.getTime("availTime2"));
		homeService.setAcceptDay1(rs.getInt("acceptDay1"));
		homeService.setAcceptDay2(rs.getInt("acceptDay2"));
		homeService.setServiceImage1(rs.getString("serviceImage1"));
		homeService.setServiceImage2(rs.getString("serviceImage2"));
		homeService.setServiceImage3(rs.getString("serviceImage3"));
		homeService.setServiceImage4(rs.getString("serviceImage4"));
		homeService.setServiceImage5(rs.getString("serviceImage5"));
		homeService.setMonday(rs.getBoolean("monday"));
		homeService.setTuesday(rs.getBoolean("tuesday"));
		homeService.setWednesday(rs.getBoolean("wednesday"));
		homeService.setThursday(rs.getBoolean("thursday"));
		homeService.setFriday(rs.getBoolean("friday"));
		homeService.setSaturday(rs.getBoolean("saturday"));
		homeService.setSunday(rs.getBoolean("sunday"));
		return homeService;
	}

}
