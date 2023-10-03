package com.ispan.eeit._06_order.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ispan.eeit._06_order.dao.OrdersDao;
import com.ispan.eeit._06_order.model.Order;

@Repository
public class OrdersDaoImpl implements OrdersDao {
	
	Logger log = LoggerFactory.getLogger(OrdersDaoImpl.class);
	@PersistenceContext
	EntityManager  entityManager;
	
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

}
