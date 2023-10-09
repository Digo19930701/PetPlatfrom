package com.ispan.eeit._21_petService.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import com.ispan.eeit._21_petService.model.PetServiceDetail;

public class PetServiceDetailRowMapper implements RowMapper<PetServiceDetail> {

	@Override
	@Nullable
	public PetServiceDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
		PetServiceDetail psd = new PetServiceDetail();
		psd.setServiceId(rs.getString("serviceId"));
		psd.setServiceName(rs.getString("serviceName"));
		psd.setSellerId(rs.getString("sellerId"));
		psd.setCategory(rs.getString("category"));
		psd.setServiceDesc(rs.getString("serviceDesc"));
		psd.setServicePeriod(rs.getTime("servicePeriod"));
		psd.setUpperLimit(rs.getInt("upperLimit"));
		psd.setAvailTime1(rs.getTime("availTime1"));
		psd.setAvailTime2(rs.getTime("availTime2"));
		psd.setAcceptDay1(rs.getInt("acceptDay1"));
		psd.setAcceptDay2(rs.getInt("acceptDay2"));
		psd.setServiceImage1(rs.getString("serviceImage1"));
		psd.setServiceImage2(rs.getString("serviceImage2"));
		psd.setServiceImage3(rs.getString("serviceImage3"));
		psd.setServiceImage4(rs.getString("serviceImage4"));
		psd.setServiceImage5(rs.getString("serviceImage5"));
		psd.setMonday(rs.getBoolean("monday"));
		psd.setTuesday(rs.getBoolean("tuesday"));
		psd.setWednesday(rs.getBoolean("wednesday"));
		psd.setThursday(rs.getBoolean("thursday"));
		psd.setFriday(rs.getBoolean("friday"));
		psd.setSaturday(rs.getBoolean("saturday"));
		psd.setSunday(rs.getBoolean("sunday"));
		psd.setHst(null);

		return psd;
	}

}
