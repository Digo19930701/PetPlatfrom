package com.ispan.eeit._06_order.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ispan.eeit._06_order.model.Order;

public class OrdersRowMapper implements RowMapper<Order>{

	@Override
	public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
		Order order = new Order();
		order.setOrderId(rs.getString("orderId"));
		order.setUserEmail(rs.getString("userEmail"));
		order.setSellerId(rs.getString("sellerId"));
		order.setTimeline1(rs.getTimestamp("timeline1"));
		order.setTotalPrice(rs.getInt("totalPrice"));
		order.setPetNum(rs.getInt("petNum"));
		order.setServiceId(rs.getString("serviceId"));
		order.setPrice(rs.getInt("price"));
		order.setOrderDateTime1(rs.getTimestamp("orderDateTime1"));
		order.setOrderDateTime2(rs.getTimestamp("orderDateTime2"));
		order.setOrderMsg(rs.getString("orderMsg"));
		
		return order;
	}

}
