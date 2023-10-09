package com.ispan.eeit._30_HomeService.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import com.ispan.eeit._30_HomeService.model.HomeServiceType;

public class HomeServiceTypeRowMapper implements RowMapper<HomeServiceType>{

	@Override
	@Nullable
	public HomeServiceType mapRow(ResultSet rs, int rowNum) throws SQLException {
		HomeServiceType hst = new HomeServiceType();
		hst.setServiceId(rs.getString("serviceId"));
		hst.setTypeId(rs.getInt("typeId"));
		hst.setPetType(rs.getString("petType"));
		hst.setSpec(rs.getString("spec"));
		hst.setPrice(rs.getInt("price"));
		
		return hst;
	}
	
}
