package com.example.ECPayDemo.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.example.ECPayDemo.bean.SellerOrder;
import com.example.ECPayDemo.controller.SellerController;
import com.example.ECPayDemo.dao.SellerOrderDao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@Repository
public class SellerOrderDaoImpl implements SellerOrderDao{
	
	Logger log = LoggerFactory.getLogger(SellerController.class);
	
	@PersistenceContext
	EntityManager  entityManager;
	SessionFactory factory;

	@Override
	public SellerOrder getOrders(String orderId) {
		SellerOrder sellerOrder = entityManager.find(SellerOrder.class, orderId);
		return sellerOrder;
	}

	@Override
	public List<SellerOrder> getSellerOrders(String sellerId) {
		log.info("read all Orders of " + sellerId + ": Dao (start).");
		List<SellerOrder> sellerOrders = null;
//		Session session = factory.getCurrentSession();
		String hql = "FROM ordertable WHERE sellerId =:sid"; //hql:Hibernate Query Languger
		sellerOrders = entityManager.createQuery(hql, SellerOrder.class)
									.setParameter("sid", sellerId)
									.getResultList();
//		sellerOrders = session.createQuery(hql, SellerOrder.class)
//				.setParameter("sid", sellerId)
//				.getResultList();
		log.info("read all Orders of " + sellerId + ": Dao (done).");
	
		return sellerOrders;
	}


}
