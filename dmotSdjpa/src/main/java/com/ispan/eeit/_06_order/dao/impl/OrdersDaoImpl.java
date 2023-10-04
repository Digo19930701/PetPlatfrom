package com.ispan.eeit._06_order.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ispan.eeit._06_order.dao.OrdersDao;
import com.ispan.eeit._06_order.model.Order;
import com.ispan.eeit._06_order.rowmapper.OrdersRowMapper;

@Repository
public class OrdersDaoImpl implements OrdersDao {
	
	Logger log = LoggerFactory.getLogger(OrdersDaoImpl.class);
	@PersistenceContext
	EntityManager  entityManager;
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Override
	public Order getOrder(String orderId) {
		Order sellerOrder = entityManager.find(Order.class, orderId);
		return sellerOrder;
	}

	@Override
	public List<Order> getBySellerId(String sellerId) {
		log.info("read all Orders of " + sellerId + ": Dao (start).");
		List<Order> sellerOrders = null;
		String hql = "FROM ordertable WHERE sellerId =:sid"; //hql:Hibernate Query Languger
		sellerOrders = entityManager.createQuery(hql, Order.class)
									.setParameter("sid", sellerId)
									.getResultList();
		log.info("read all Orders of " + sellerId + ": Dao (done).");
		return sellerOrders;
	}

	@Override
	public List<Order> getOrdersBySellerId(String sellerId) {
		String sql = "SELECT * FROM ordertable WHERE sellerId =:sellerId";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sellerId", sellerId);
		List<Order> orders = namedParameterJdbcTemplate.query(sql, map, new OrdersRowMapper());
		
		if(orders.size() > 0) {
			log.info("got orders of seller(" + sellerId + ").");
			return orders;			
		}else {
			log.info("order of seller(" + sellerId + ") not found.");
			return null;
		}
		
	}
	
}
